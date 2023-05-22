/*     */ package postgres95;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Statement;
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
/*     */ public class PGStatement
/*     */   implements Statement
/*     */ {
/*     */   static final int MAX_MESSAGE_LEN = 8194;
/*     */   PGConnection parent;
/*     */   long results;
/*  40 */   int MaxFieldSize = 8192;
/*     */   int MaxRows;
/*     */   boolean escape = true;
/*     */   long QueryTimeout;
/*     */   SQLWarning warnings;
/*     */   Vector resultSets;
/*     */   Vector statuses;
/*     */   Vector notifies;
/*     */   int currentResult;
/*     */   
/*     */   PGStatement(PGConnection paramPGConnection) {
/*  51 */     this.parent = paramPGConnection;
/*  52 */     clearStatus();
/*     */   }
/*     */   
/*     */   private void clearStatus() {
/*  56 */     this.resultSets = new Vector();
/*  57 */     this.statuses = new Vector();
/*  58 */     this.notifies = new Vector();
/*  59 */     this.currentResult = 0;
/*     */   }
/*     */   
/*     */   private void sendQuery(String paramString) throws SQLException {
/*  63 */     byte[] arrayOfByte = new byte[8194];
/*  64 */     if (paramString.length() > 8192)
/*  65 */       throw new SQLException("Query too long.  Maximum is " + 
/*  66 */           ' '); 
/*  67 */     arrayOfByte[0] = 81;
/*     */ 
/*     */ 
/*     */     
/*  71 */     System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 1, paramString.length());
/*     */     
/*  73 */     arrayOfByte[paramString.length() + 1] = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  81 */       this.parent.sock_out.write(arrayOfByte, 0, paramString.length() + 2);
/*  82 */       this.parent.sock_out.flush(); return;
/*  83 */     } catch (Exception exception) {
/*  84 */       throw new SQLException("Network write error: " + exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String readline() throws SQLException {
/*  89 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*     */     while (true) {
/*     */       byte b;
/*     */       try {
/*  94 */         b = (byte)this.parent.sock_in.read();
/*  95 */       } catch (Exception exception) {
/*  96 */         throw new SQLException("Network read error: " + exception);
/*     */       } 
/*  98 */       if (b != 0) {
/*     */         
/* 100 */         stringBuffer.append((char)b); continue;
/*     */       }  break;
/* 102 */     }  return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   protected short readint2() throws SQLException {
/*     */     try {
/* 107 */       int i = this.parent.sock_in.readUnsignedByte();
/* 108 */       return (short)(i | this.parent.sock_in.readUnsignedByte() << 8);
/* 109 */     } catch (Exception exception) {
/* 110 */       throw new SQLException("Network read error: " + exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected int readint4() throws SQLException {
/*     */     try {
/* 116 */       int i = this.parent.sock_in.readUnsignedByte();
/* 117 */       i |= this.parent.sock_in.readUnsignedByte() << 8;
/* 118 */       i |= this.parent.sock_in.readUnsignedByte() << 16;
/* 119 */       return i | this.parent.sock_in.readUnsignedByte() << 24;
/* 120 */     } catch (Exception exception) {
/* 121 */       throw new SQLException("Network read error: " + exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void readResults() throws SQLException {
/* 126 */     String str = null; try {
/*     */       while (true) {
/*     */         short s; byte[] arrayOfByte1, arrayOfByte2;
/*     */         SQLWarning sQLWarning;
/* 130 */         int i = this.parent.sock_in.read();
/*     */         
/* 132 */         switch (i) {
/*     */           case 65:
/* 134 */             s = readint2();
/* 135 */             arrayOfByte1 = new byte[16];
/* 136 */             this.parent.sock_in.readFully(arrayOfByte1, 0, 16);
/* 137 */             if (this.notifies == null)
/* 138 */               this.notifies = new Vector(); 
/* 139 */             this.notifies.addElement(new PGNotify(s, arrayOfByte1));
/*     */             continue;
/*     */           case 67:
/* 142 */             this.statuses.addElement(readline());
/* 143 */             arrayOfByte2 = new byte[3];
/* 144 */             arrayOfByte2[0] = 81;
/* 145 */             arrayOfByte2[1] = 32;
/* 146 */             arrayOfByte2[2] = 0;
/*     */             
/*     */             while (true) {
/* 149 */               this.parent.sock_out.write(arrayOfByte2, 0, 3);
/* 150 */               this.parent.sock_out.flush();
/*     */               
/* 152 */               String str1 = readline();
/* 153 */               if (str1.length() > 0 && 
/* 154 */                 str1.charAt(0) == 'I') {
/* 155 */                 if (str1.length() > 1)
/* 156 */                   throw new SQLException("Network protocol failure"); 
/*     */                 break;
/*     */               } 
/* 159 */               this.statuses.addElement(str1);
/*     */             } 
/*     */             return;
/*     */           case 69:
/* 163 */             throw new SQLException("Error received", readline());
/*     */           case 73:
/* 165 */             if (readline().length() > 0)
/* 166 */               throw new SQLException("Network protocol failure"); 
/* 167 */             this.resultSets.addElement(null);
/*     */             return;
/*     */           case 78:
/* 170 */             sQLWarning = new SQLWarning("Error: " + readline());
/* 171 */             if (this.warnings != null)
/* 172 */               sQLWarning.setNextException(this.warnings); 
/* 173 */             this.warnings = sQLWarning;
/*     */             continue;
/*     */           case 80:
/* 176 */             str = readline();
/*     */             continue;
/*     */           
/*     */           case 84:
/* 180 */             this.resultSets.addElement(new PGResultSet(this, str, this.parent.sock_in));
/*     */             return;
/*     */           
/*     */           case 68:
/*     */             return;
/*     */           
/*     */           case 66:
/*     */             return;
/*     */         } 
/*     */         break;
/*     */       } 
/* 191 */       throw new SQLException("Network protocol error");
/*     */     }
/* 193 */     catch (SQLException sQLException) {
/* 194 */       throw sQLException;
/* 195 */     } catch (Exception exception) {
/* 196 */       throw new SQLException("Network read error: " + exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet executeQuery(String paramString) throws SQLException {
/* 205 */     if (execute(paramString))
/* 206 */       return this.resultSets.firstElement(); 
/* 207 */     throw new SQLException("No ResultSet returned");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate(String paramString) throws SQLException {
/* 215 */     execute(paramString);
/* 216 */     if (this.statuses.size() > 0)
/*     */       try {
/* 218 */         return Integer.valueOf(this.statuses.firstElement()).intValue();
/* 219 */       } catch (Exception exception) {
/* 220 */         return 1;
/*     */       }  
/* 222 */     throw new SQLException("No Status returned");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxFieldSize() throws SQLException {
/* 240 */     return this.MaxFieldSize;
/*     */   }
/*     */   public void setMaxFieldSize(int paramInt) throws SQLException {
/* 243 */     this.MaxFieldSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxRows() throws SQLException {
/* 250 */     return this.MaxRows;
/*     */   }
/*     */   public void setMaxRows(int paramInt) throws SQLException {
/* 253 */     this.MaxRows = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscapeProcessing(boolean paramBoolean) throws SQLException {
/* 259 */     this.escape = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getQueryTimeout() throws SQLException {
/* 265 */     return (int)(this.QueryTimeout / 1000L);
/*     */   }
/*     */   public void setQueryTimeout(int paramInt) throws SQLException {
/* 268 */     this.QueryTimeout = (paramInt * 1000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 283 */     return this.warnings;
/*     */   }
/*     */   public void clearWarnings() throws SQLException {
/* 286 */     this.warnings = null;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void exec(String paramString) throws SQLException {
/* 303 */     clearStatus();
/* 304 */     sendQuery(paramString);
/* 305 */     readResults();
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
/*     */   public boolean execute(String paramString) throws SQLException {
/* 317 */     if (this.parent.autoCommit)
/* 318 */       this.parent.begin(); 
/* 319 */     exec(paramString);
/* 320 */     if (this.parent.autoCommit)
/* 321 */       this.parent.commit(); 
/* 322 */     if (this.resultSets.size() > 0)
/* 323 */       return true; 
/* 324 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet getResultSet() throws SQLException {
/* 330 */     if (this.currentResult < this.resultSets.size())
/* 331 */       return this.resultSets.elementAt(this.currentResult); 
/* 332 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUpdateCount() throws SQLException {
/* 339 */     if (this.currentResult >= this.resultSets.size() && 
/* 340 */       this.currentResult - this.resultSets.size() < this.statuses.size())
/* 341 */       return Integer.valueOf(this.statuses.firstElement()).intValue(); 
/* 342 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getMoreResults() throws SQLException {
/* 349 */     if (this.currentResult < this.resultSets.size()) {
/* 350 */       (PGResultSet)this.resultSets.elementAt(this.currentResult);
/*     */     }
/*     */     
/* 353 */     if (++this.currentResult >= this.resultSets.size())
/* 354 */       return false; 
/* 355 */     return true;
/*     */   }
/*     */   
/*     */   public void setCursorName(String paramString) throws SQLException {}
/*     */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGStatement.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */