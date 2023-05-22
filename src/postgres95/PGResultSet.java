/*     */ package postgres95;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.sql.Date;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGResultSet
/*     */   implements ResultSet
/*     */ {
/*     */   PGStatement parent;
/*     */   String name;
/*     */   Vector columns;
/*     */   Vector tuples;
/*     */   int currentRow;
/*     */   private Hashtable months;
/*     */   private boolean wasException;
/*     */   private PGResultSetMetaData meta;
/*     */   
/*     */   private Vector readTuple(DataInputStream paramDataInputStream, short paramShort, boolean paramBoolean) throws SQLException {
/*  46 */     Vector vector = new Vector();
/*  47 */     int i = paramShort / 8;
/*     */     
/*  49 */     byte b1 = 0;
/*  50 */     byte b2 = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  56 */       if (paramShort % 8 > 0) {
/*  57 */         i++;
/*     */       }
/*  59 */       byte[] arrayOfByte = new byte[i + 1];
/*     */       
/*  61 */       paramDataInputStream.read(arrayOfByte, 0, i);
/*     */ 
/*     */       
/*  64 */       byte b3 = arrayOfByte[b1];
/*     */       
/*  66 */       for (byte b = 0; b < paramShort; b++) {
/*  67 */         if ((b3 & 0x80) == 0) {
/*  68 */           vector.addElement(null);
/*     */         } else {
/*  70 */           int j = this.parent.readint4();
/*     */           
/*  72 */           if (!paramBoolean) {
/*  73 */             j -= 4;
/*     */           }
/*  75 */           if (j > 0) {
/*  76 */             byte[] arrayOfByte1 = new byte[j];
/*  77 */             paramDataInputStream.read(arrayOfByte1, 0, j);
/*  78 */             if (!paramBoolean)
/*     */             
/*     */             { 
/*  81 */               vector.addElement(new String(arrayOfByte1)); }
/*     */             else
/*  83 */             { vector.addElement(arrayOfByte1); } 
/*  84 */           } else if (!paramBoolean) {
/*  85 */             vector.addElement("");
/*     */           } else {
/*  87 */             vector.addElement(null);
/*     */           } 
/*  89 */         }  if (++b2 == 8)
/*  90 */         { b3 = arrayOfByte[++b1];
/*  91 */           b2 = 0; }
/*     */         else
/*  93 */         { int j = b3 << 1; } 
/*     */       } 
/*  95 */     } catch (Exception exception) {
/*  96 */       throw new SQLException("Network error reading results" + exception);
/*     */     } 
/*  98 */     return vector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readResult(DataInputStream paramDataInputStream) throws SQLException {
/* 112 */     this.columns = new Vector();
/* 113 */     this.tuples = new Vector();
/* 114 */     this.currentRow = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 119 */       short s = this.parent.readint2();
/*     */ 
/*     */       
/* 122 */       for (s = (short)(s - 1); s > 0; ) {
/* 123 */         PGColumn pGColumn = new PGColumn();
/* 124 */         pGColumn.name = this.parent.readline();
/* 125 */         pGColumn.oid = this.parent.readint4();
/* 126 */         pGColumn.size = this.parent.readint2();
/* 127 */         this.columns.addElement(pGColumn);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       boolean bool = true;
/* 134 */       while (bool) {
/* 135 */         String str1, str2; SQLWarning sQLWarning; int i = paramDataInputStream.read();
/* 136 */         switch (i) {
/*     */           case 84:
/* 138 */             throw new SQLException("Multiple tuple results not supported");
/*     */           
/*     */           case 66:
/*     */           case 68:
/* 142 */             this.tuples.addElement(
/* 143 */                 readTuple(paramDataInputStream, (short)this.columns.size(), !(i != 66)));
/*     */             continue;
/*     */ 
/*     */           
/*     */           case 65:
/* 148 */             throw new SQLException("Asychronous portals not supported");
/*     */           
/*     */           case 67:
/* 151 */             this.parent.readline();
/* 152 */             bool = false;
/*     */             continue;
/*     */           
/*     */           case 69:
/* 156 */             str1 = this.parent.readline();
/* 157 */             throw new SQLException("Tuple Error: " + str1);
/*     */           
/*     */           case 78:
/* 160 */             str2 = this.parent.readline();
/* 161 */             sQLWarning = new SQLWarning("Error: " + str2);
/* 162 */             if (this.parent.warnings != null)
/* 163 */               sQLWarning.setNextException(this.parent.warnings); 
/* 164 */             this.parent.warnings = sQLWarning;
/*     */             continue;
/*     */         } 
/*     */         
/* 168 */         throw new SQLException("Network protocol error reading results: " + i);
/*     */       } 
/*     */       return;
/* 171 */     } catch (Exception exception) {
/* 172 */       throw new SQLException("Network error reading results");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PGResultSet(PGStatement paramPGStatement, String paramString, DataInputStream paramDataInputStream) throws SQLException {
/* 183 */     this.months = new Hashtable();
/* 184 */     this.months.put("Jan", new Integer(1));
/* 185 */     this.months.put("Feb", new Integer(2));
/* 186 */     this.months.put("Mar", new Integer(3));
/* 187 */     this.months.put("Apr", new Integer(4));
/* 188 */     this.months.put("May", new Integer(5));
/* 189 */     this.months.put("Jun", new Integer(6));
/* 190 */     this.months.put("Jul", new Integer(7));
/* 191 */     this.months.put("Aug", new Integer(8));
/* 192 */     this.months.put("Sep", new Integer(9));
/* 193 */     this.months.put("Oct", new Integer(10));
/* 194 */     this.months.put("Nov", new Integer(11));
/* 195 */     this.months.put("Dec", new Integer(12));
/*     */     
/* 197 */     this.parent = paramPGStatement;
/* 198 */     this.name = paramString;
/*     */     
/* 200 */     readResult(paramDataInputStream);
/* 201 */     this.meta = new PGResultSetMetaData(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String value(String paramString) throws SQLException {
/* 210 */     return value(findColumn(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   private Object value(int paramInt1, int paramInt2) throws SQLException {
/*     */     try {
/* 216 */       return ((Vector)this.tuples.elementAt(paramInt1 - 1)).elementAt(paramInt2 - 1);
/* 217 */     } catch (Exception exception) {
/* 218 */       throw new SQLException("Out of result set bounds? value(int, int)" + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Object ovalue(int paramInt) throws SQLException {
/*     */     try {
/* 225 */       return ((Vector)this.tuples.elementAt(this.currentRow - 1)).elementAt(paramInt - 1);
/* 226 */     } catch (Exception exception) {
/* 227 */       throw new SQLException("Out of result set bounds? ovalue(int)" + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String value(int paramInt) throws SQLException {
/*     */     try {
/* 234 */       return ((Vector)this.tuples.elementAt(this.currentRow - 1)).elementAt(paramInt - 1);
/* 235 */     } catch (Exception exception) {
/* 236 */       throw new SQLException("value(int) CR:" + (this.currentRow - 1) + " CL:" + (paramInt - 1) + "->" + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private byte[] bvalue(String paramString) throws SQLException {
/* 242 */     for (byte b = 0; b < this.columns.size(); b++) {
/* 243 */       PGColumn pGColumn = this.columns.elementAt(b);
/* 244 */       if (pGColumn.name.equals(paramString))
/* 245 */         return bvalue(b + 1); 
/*     */     } 
/* 247 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private byte[] bvalue(int paramInt) throws SQLException {
/*     */     try {
/* 253 */       return ((Vector)this.tuples.elementAt(this.currentRow - 1)).elementAt(paramInt - 1);
/* 254 */     } catch (Exception exception) {
/* 255 */       throw new SQLException("Out of result set bounds? " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isNull(int paramInt) throws SQLException {
/* 264 */     return !(value(paramInt) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isNull(String paramString) throws SQLException {
/* 269 */     return !(value(paramString) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void printTuples() {
/* 279 */     PGd.h("===============================");
/* 280 */     for (byte b = 0; b < this.tuples.size(); b++) {
/* 281 */       Vector vector = this.tuples.elementAt(b);
/* 282 */       for (byte b1 = 0; b1 < vector.size(); b1++) {
/* 283 */         PGd.h("I: " + b + " J: " + b1 + " =" + vector.elementAt(b1));
/*     */       }
/*     */     } 
/* 286 */     PGd.h("===============================");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean wasNull() throws SQLException {
/* 292 */     return this.wasException;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(int paramInt) throws SQLException {
/* 298 */     this.wasException = false;
/*     */     
/*     */     try {
/* 301 */       if (isNull(paramInt)) {
/* 302 */         return null;
/*     */       }
/* 304 */       return value(paramInt);
/* 305 */     } catch (Exception exception) {
/* 306 */       this.wasException = true;
/* 307 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String paramString) throws SQLException {
/* 314 */     this.wasException = false;
/*     */     try {
/* 316 */       if (isNull(paramString)) {
/* 317 */         return null;
/*     */       }
/* 319 */       return value(paramString);
/* 320 */     } catch (Exception exception) {
/* 321 */       this.wasException = true;
/* 322 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(int paramInt) throws SQLException {
/* 328 */     this.wasException = false;
/*     */     try {
/* 330 */       return !(value(paramInt).compareTo("t") != 0);
/* 331 */     } catch (Exception exception) {
/* 332 */       this.wasException = true;
/* 333 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String paramString) throws SQLException {
/* 339 */     this.wasException = false;
/*     */     try {
/* 341 */       return !(value(paramString).compareTo("t") != 0);
/* 342 */     } catch (Exception exception) {
/* 343 */       this.wasException = true;
/* 344 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getByte(int paramInt) throws SQLException {
/* 350 */     this.wasException = false;
/*     */     try {
/* 352 */       return (byte)Integer.valueOf(value(paramInt)).intValue();
/* 353 */     } catch (Exception exception) {
/* 354 */       this.wasException = true;
/* 355 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getByte(String paramString) throws SQLException {
/* 361 */     this.wasException = false;
/*     */     try {
/* 363 */       return (byte)Integer.valueOf(value(paramString)).intValue();
/* 364 */     } catch (Exception exception) {
/* 365 */       this.wasException = true;
/* 366 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public short getShort(int paramInt) throws SQLException {
/* 372 */     this.wasException = false;
/*     */     try {
/* 374 */       return (short)Integer.valueOf(value(paramInt)).intValue();
/* 375 */     } catch (Exception exception) {
/* 376 */       this.wasException = true;
/* 377 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public short getShort(String paramString) throws SQLException {
/* 383 */     this.wasException = false;
/*     */     try {
/* 385 */       return (short)Integer.valueOf(value(paramString)).intValue();
/* 386 */     } catch (Exception exception) {
/* 387 */       this.wasException = true;
/* 388 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(int paramInt) throws SQLException {
/* 394 */     this.wasException = false;
/*     */     try {
/* 396 */       if (isNull(paramInt)) {
/* 397 */         return 0;
/*     */       }
/* 399 */       return Integer.valueOf(value(paramInt)).intValue();
/* 400 */     } catch (Exception exception) {
/* 401 */       this.wasException = true;
/* 402 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(String paramString) throws SQLException {
/* 408 */     this.wasException = false;
/*     */     try {
/* 410 */       if (isNull(paramString)) {
/* 411 */         return 0;
/*     */       }
/* 413 */       return Integer.valueOf(value(paramString)).intValue();
/* 414 */     } catch (Exception exception) {
/* 415 */       this.wasException = true;
/* 416 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(int paramInt) throws SQLException {
/* 422 */     this.wasException = false;
/*     */     try {
/* 424 */       if (isNull(paramInt)) {
/* 425 */         return 0L;
/*     */       }
/* 427 */       return Long.valueOf(value(paramInt)).longValue();
/* 428 */     } catch (Exception exception) {
/* 429 */       this.wasException = true;
/* 430 */       throw new SQLException("getLong(int) conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(String paramString) throws SQLException {
/* 436 */     this.wasException = false;
/*     */     try {
/* 438 */       if (isNull(paramString)) {
/* 439 */         return 0L;
/*     */       }
/* 441 */       return Long.valueOf(value(paramString)).longValue();
/* 442 */     } catch (Exception exception) {
/* 443 */       this.wasException = true;
/* 444 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(int paramInt) throws SQLException {
/* 450 */     this.wasException = false;
/*     */     try {
/* 452 */       if (isNull(paramInt)) {
/* 453 */         return 0.0F;
/*     */       }
/* 455 */       return Float.valueOf(value(paramInt)).floatValue();
/* 456 */     } catch (Exception exception) {
/* 457 */       this.wasException = true;
/* 458 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(String paramString) throws SQLException {
/* 464 */     this.wasException = false;
/*     */     try {
/* 466 */       if (isNull(paramString)) {
/* 467 */         return 0.0F;
/*     */       }
/* 469 */       return Float.valueOf(value(paramString)).floatValue();
/* 470 */     } catch (Exception exception) {
/* 471 */       this.wasException = true;
/* 472 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDouble(int paramInt) throws SQLException {
/* 478 */     this.wasException = false;
/*     */     try {
/* 480 */       if (isNull(paramInt)) {
/* 481 */         return 0.0D;
/*     */       }
/* 483 */       return Double.valueOf(value(paramInt)).doubleValue();
/* 484 */     } catch (Exception exception) {
/* 485 */       this.wasException = true;
/* 486 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDouble(String paramString) throws SQLException {
/* 492 */     this.wasException = false;
/*     */     try {
/* 494 */       if (isNull(paramString)) {
/* 495 */         return 0.0D;
/*     */       }
/* 497 */       return Double.valueOf(value(paramString)).doubleValue();
/* 498 */     } catch (Exception exception) {
/* 499 */       this.wasException = true;
/* 500 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal(int paramInt1, int paramInt2) throws SQLException {
/* 506 */     this.wasException = false;
/*     */     try {
/* 508 */       return new BigDecimal(new BigInteger(value(paramInt1)), paramInt2);
/* 509 */     } catch (Exception exception) {
/* 510 */       this.wasException = true;
/* 511 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal(String paramString, int paramInt) throws SQLException {
/* 517 */     this.wasException = false;
/*     */     try {
/* 519 */       return new BigDecimal(new BigInteger(value(paramString)));
/* 520 */     } catch (Exception exception) {
/* 521 */       this.wasException = true;
/* 522 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes(int paramInt) throws SQLException {
/* 528 */     return bvalue(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes(String paramString) throws SQLException {
/* 533 */     return bvalue(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getLongBinaryStream(int paramInt) throws SQLException {
/* 538 */     return bvalue(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getLongBinaryStream(String paramString) throws SQLException {
/* 543 */     return bvalue(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDate(int paramInt) throws SQLException {
/* 548 */     this.wasException = false;
/*     */     try {
/* 550 */       String str = value(paramInt);
/*     */ 
/*     */       
/* 553 */       if (str == null) return null;
/*     */       
/* 555 */       int i = Integer.valueOf(str.substring(0, 2)).intValue();
/* 556 */       int j = Integer.valueOf(str.substring(3, 5)).intValue();
/* 557 */       int k = Integer.valueOf(str.substring(6, 10)).intValue();
/* 558 */       return new Date(k - 1900, i - 1, j);
/* 559 */     } catch (Exception exception) {
/* 560 */       this.wasException = true;
/* 561 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDate(String paramString) throws SQLException {
/* 567 */     this.wasException = false;
/*     */     try {
/* 569 */       String str = value(paramString);
/*     */ 
/*     */       
/* 572 */       if (str == null) return null;
/*     */       
/* 574 */       int i = Integer.valueOf(str.substring(0, 2)).intValue();
/* 575 */       int j = Integer.valueOf(str.substring(3, 5)).intValue();
/* 576 */       int k = Integer.valueOf(str.substring(6, 10)).intValue();
/* 577 */       return new Date(k - 1900, i - 1, j);
/* 578 */     } catch (Exception exception) {
/* 579 */       this.wasException = true;
/* 580 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Time getTime(int paramInt) throws SQLException {
/* 586 */     this.wasException = false;
/*     */     try {
/* 588 */       String str = value(paramInt);
/*     */ 
/*     */       
/* 591 */       if (str == null) return null;
/*     */       
/* 593 */       int i = Integer.valueOf(str.substring(0, 2)).intValue();
/* 594 */       int j = Integer.valueOf(str.substring(3, 5)).intValue();
/* 595 */       int k = Integer.valueOf(str.substring(6, 9)).intValue();
/* 596 */       return new Time(i, j, k);
/* 597 */     } catch (Exception exception) {
/* 598 */       this.wasException = true;
/* 599 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Time getTime(String paramString) throws SQLException {
/* 605 */     this.wasException = false;
/*     */     try {
/* 607 */       String str = value(paramString);
/*     */ 
/*     */       
/* 610 */       if (str == null) return null;
/*     */       
/* 612 */       int i = Integer.valueOf(str.substring(0, 2)).intValue();
/* 613 */       int j = Integer.valueOf(str.substring(3, 5)).intValue();
/* 614 */       int k = Integer.valueOf(str.substring(6, 9)).intValue();
/* 615 */       return new Time(i, j, k);
/* 616 */     } catch (Exception exception) {
/* 617 */       this.wasException = true;
/* 618 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp(int paramInt) throws SQLException {
/*     */     try {
/* 626 */       String str = value(paramInt);
/* 627 */       if (str == null) return null;
/*     */       
/* 629 */       return new Timestamp(
/* 630 */           Integer.valueOf(str.substring(20, 24)).intValue() - 1900, (
/* 631 */           (Integer)this.months.get(str.substring(4, 7))).intValue(), 
/* 632 */           Integer.valueOf(str.substring(8, 10)).intValue(), 
/* 633 */           Integer.valueOf(str.substring(11, 13)).intValue(), 
/* 634 */           Integer.valueOf(str.substring(14, 16)).intValue(), 
/* 635 */           Integer.valueOf(str.substring(17, 19)).intValue(), 
/* 636 */           0);
/*     */     }
/* 638 */     catch (Exception exception) {
/* 639 */       this.wasException = true;
/* 640 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp(String paramString) throws SQLException {
/*     */     try {
/* 647 */       String str = value(paramString);
/* 648 */       if (str == null) return null;
/*     */       
/* 650 */       return new Timestamp(
/* 651 */           Integer.valueOf(str.substring(20, 24)).intValue() - 1900, (
/* 652 */           (Integer)this.months.get(str.substring(4, 7))).intValue(), 
/* 653 */           Integer.valueOf(str.substring(8, 10)).intValue(), 
/* 654 */           Integer.valueOf(str.substring(11, 13)).intValue(), 
/* 655 */           Integer.valueOf(str.substring(14, 16)).intValue(), 
/* 656 */           Integer.valueOf(str.substring(17, 19)).intValue(), 
/* 657 */           0);
/*     */     }
/* 659 */     catch (Exception exception) {
/* 660 */       this.wasException = true;
/* 661 */       throw new SQLException("Result conversion error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getAsciiStream(int paramInt) throws SQLException {
/* 674 */     String str = value(paramInt);
/* 675 */     byte[] arrayOfByte = new byte[str.length()];
/*     */ 
/*     */ 
/*     */     
/* 679 */     System.arraycopy(str.getBytes(), 0, arrayOfByte, 0, str.length());
/*     */     
/* 681 */     return new ByteArrayInputStream(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getAsciiStream(String paramString) throws SQLException {
/* 686 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getUnicodeStream(int paramInt) throws SQLException {
/* 691 */     return getAsciiStream(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getUnicodeStream(String paramString) throws SQLException {
/* 696 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getBinaryStream(int paramInt) throws SQLException {
/* 701 */     return new ByteArrayInputStream(bvalue(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getBinaryStream(String paramString) throws SQLException {
/* 706 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean next() throws SQLException {
/* 714 */     if (this.tuples == null) {
/* 715 */       PGd.h("tuples == null!");
/* 716 */       return false;
/*     */     } 
/* 718 */     return !(++this.currentRow > this.tuples.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowNumber() throws SQLException {
/* 725 */     return this.currentRow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnCount() throws SQLException {
/* 731 */     return this.columns.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowCount() throws SQLException {
/* 738 */     return this.tuples.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {
/* 746 */     this.columns = null;
/* 747 */     this.tuples = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCursorName() throws SQLException {
/* 759 */     printTuples();
/* 760 */     return (new Integer(this.currentRow)).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSetMetaData getMetaData() throws SQLException {
/* 767 */     return this.meta;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject(String paramString) throws SQLException {
/* 772 */     return getObject(findColumn(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(int paramInt) throws SQLException {
/*     */     try {
/* 779 */       switch (this.meta.getColumnType(paramInt)) {
/*     */ 
/*     */         
/*     */         case -7:
/* 783 */           return new Boolean(getBoolean(paramInt));
/*     */         
/*     */         case -6:
/* 786 */           return new Integer(getByte(paramInt));
/*     */         
/*     */         case 5:
/* 789 */           return new Integer(getShort(paramInt));
/*     */         
/*     */         case 4:
/* 792 */           return new Integer(getInt(paramInt));
/*     */         
/*     */         case -5:
/* 795 */           return new Long(getLong(paramInt));
/*     */         
/*     */         case 6:
/* 798 */           return new Float(getDouble(paramInt));
/*     */         
/*     */         case 7:
/* 801 */           return new Float(getFloat(paramInt));
/*     */         
/*     */         case 8:
/* 804 */           return new Double(getDouble(paramInt));
/*     */ 
/*     */         
/*     */         case 2:
/* 808 */           return getBigDecimal(paramInt, 0);
/*     */ 
/*     */         
/*     */         case 3:
/* 812 */           return getBigDecimal(paramInt, 0);
/*     */         
/*     */         case 1:
/* 815 */           return getString(paramInt);
/*     */         
/*     */         case 12:
/* 818 */           return getString(paramInt);
/*     */         
/*     */         case -1:
/* 821 */           return getAsciiStream(paramInt);
/*     */         
/*     */         case 91:
/* 824 */           return getDate(paramInt);
/*     */         
/*     */         case 92:
/* 827 */           return getTime(paramInt);
/*     */         
/*     */         case 93:
/* 830 */           return getTimestamp(paramInt);
/*     */         
/*     */         case -2:
/* 833 */           return getBytes(paramInt);
/*     */         
/*     */         case -3:
/* 836 */           return getBytes(paramInt);
/*     */         
/*     */         case -4:
/* 839 */           return getBinaryStream(paramInt);
/*     */         
/*     */         case 0:
/* 842 */           return null;
/*     */       } 
/*     */       
/* 845 */       return null;
/*     */     }
/* 847 */     catch (Exception exception) {
/* 848 */       throw new SQLException("getObject-Eception: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int SQLtype(int paramInt) {
/* 854 */     switch (paramInt) {
/*     */       
/*     */       case 16:
/* 857 */         return -7;
/*     */       
/*     */       case 18:
/* 860 */         return 1;
/*     */       
/*     */       case 21:
/* 863 */         return 5;
/*     */       
/*     */       case 23:
/* 866 */         return 4;
/*     */       
/*     */       case 1043:
/* 869 */         return 12;
/*     */       
/*     */       case 1082:
/* 872 */         return 91;
/*     */       
/*     */       case 1083:
/* 875 */         return 92;
/*     */     } 
/* 877 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 882 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearWarnings() throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int findColumn(String paramString) throws SQLException {
/* 892 */     for (byte b = 0; b < this.columns.size(); b++) {
/* 893 */       PGColumn pGColumn = this.columns.elementAt(b);
/* 894 */       if (pGColumn.name.equals(paramString)) {
/* 895 */         return b + 1;
/*     */       }
/*     */     } 
/* 898 */     throw new SQLException("Couldn't find " + paramString + " in ResultSet");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGResultSet.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */