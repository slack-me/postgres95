/*     */ package postgres95;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
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
/*     */ public class PGPreparedStatement
/*     */   extends PGStatement
/*     */   implements PreparedStatement
/*     */ {
/*     */   String query;
/*     */   Vector parms;
/*     */   SimpleDateFormat sdf;
/*     */   
/*     */   PGPreparedStatement(PGConnection paramPGConnection, String paramString) {
/*  45 */     super(paramPGConnection);
/*  46 */     this.query = paramString;
/*  47 */     this.parms = new Vector();
/*  48 */     this.sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy zzz");
/*     */   }
/*     */   
/*     */   protected String prepareParm(PGparameter paramPGparameter) {
/*  52 */     switch (paramPGparameter.type) {
/*     */       case -7:
/*     */       case -6:
/*     */       case -5:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*  63 */         return (String)paramPGparameter.value;
/*     */       
/*     */       case -1:
/*     */       case 1:
/*     */       case 12:
/*     */       case 91:
/*     */       case 92:
/*  70 */         if (paramPGparameter.value != null) {
/*  71 */           return "'" + paramPGparameter.value + "'";
/*     */         }
/*  73 */         return "null";
/*     */ 
/*     */       
/*     */       case 93:
/*  77 */         if (paramPGparameter.value != null) {
/*  78 */           return "'" + this.sdf.format((Date)paramPGparameter.value) + "'";
/*     */         }
/*  80 */         return "null";
/*     */       
/*     */       case -4:
/*     */       case -3:
/*     */       case -2:
/*  85 */         return (String)paramPGparameter.value;
/*     */       case 0:
/*  87 */         return null;
/*     */     } 
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String prepareQuery() throws SQLException {
/*  95 */     StringBuffer stringBuffer = new StringBuffer();
/*  96 */     int i = 0;
/*     */     
/*  98 */     byte b = 0;
/*     */     
/*     */     try {
/*     */       while (true) {
/* 102 */         int j = this.query.indexOf("?", i);
/* 103 */         if (j == -1) {
/* 104 */           stringBuffer.append(this.query.substring(i));
/*     */           break;
/*     */         } 
/* 107 */         if (j > i)
/* 108 */           stringBuffer.append(this.query.substring(i, j)); 
/* 109 */         i = j + 1;
/* 110 */         stringBuffer.append(prepareParm(this.parms.elementAt(b++)));
/*     */       } 
/* 112 */     } catch (Exception exception) {
/*     */       
/* 114 */       exception.printStackTrace();
/*     */       
/* 116 */       throw new SQLException("Query parameter insertion failed: " + exception);
/*     */     } 
/*     */     
/* 119 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultSet executeQuery() throws SQLException {
/* 124 */     return executeQuery(prepareQuery());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate() throws SQLException {
/* 130 */     return executeUpdate(prepareQuery());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setparm(int paramInt1, Object paramObject, int paramInt2) {
/* 137 */     while (this.parms.size() < paramInt1)
/* 138 */       this.parms.addElement(null); 
/* 139 */     this.parms.setElementAt(new PGparameter(paramObject, paramInt2), paramInt1 - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNull(int paramInt1, int paramInt2) throws SQLException {
/* 144 */     setparm(paramInt1, null, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoolean(int paramInt, boolean paramBoolean) throws SQLException {
/* 150 */     setparm(paramInt, paramBoolean ? "t" : "f", -7);
/*     */   }
/*     */   public void setByte(int paramInt, byte paramByte) throws SQLException {
/* 153 */     setparm(paramInt, (new Integer(paramByte)).toString(), -6);
/*     */   }
/*     */   public void setShort(int paramInt, short paramShort) throws SQLException {
/* 156 */     setparm(paramInt, (new Integer(paramShort)).toString(), 5);
/*     */   }
/*     */   public void setInt(int paramInt1, int paramInt2) throws SQLException {
/* 159 */     setparm(paramInt1, (new Integer(paramInt2)).toString(), 4);
/*     */   }
/*     */   public void setLong(int paramInt, long paramLong) throws SQLException {
/* 162 */     setparm(paramInt, (new Long(paramLong)).toString(), -5);
/*     */   }
/*     */   public void setFloat(int paramInt, float paramFloat) throws SQLException {
/* 165 */     setparm(paramInt, (new Float(paramFloat)).toString(), 6);
/*     */   }
/*     */   public void setDouble(int paramInt, double paramDouble) throws SQLException {
/* 168 */     setparm(paramInt, (new Double(paramDouble)).toString(), 8);
/*     */   }
/*     */   public void setBigDecimal(int paramInt, BigDecimal paramBigDecimal) throws SQLException {
/* 171 */     setparm(paramInt, paramBigDecimal.toString(), 2);
/*     */   }
/*     */   public void setString(int paramInt, String paramString) throws SQLException {
/* 174 */     setparm(paramInt, paramString, 1);
/*     */   }
/*     */   public void setBytes(int paramInt, byte[] paramArrayOfbyte) throws SQLException {
/* 177 */     setparm(paramInt, paramArrayOfbyte, -2);
/*     */   }
/*     */   public void setBinaryStream(int paramInt, byte[] paramArrayOfbyte) throws SQLException {
/* 180 */     setparm(paramInt, paramArrayOfbyte, -4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDate(int paramInt, Date paramDate) throws SQLException {
/* 186 */     GregorianCalendar gregorianCalendar = new GregorianCalendar();
/* 187 */     gregorianCalendar.setTime(paramDate);
/* 188 */     setparm(paramInt, 
/* 189 */         String.valueOf((gregorianCalendar.get(2) < 9) ? "0" : "") + 
/* 190 */         Integer.toString(gregorianCalendar.get(2) + 1) + "-" + (
/* 191 */         (gregorianCalendar.get(5) < 10) ? "0" : "") + 
/* 192 */         Integer.toString(gregorianCalendar.get(5)) + "-" + 
/* 193 */         Integer.toString(gregorianCalendar.get(1)), 
/* 194 */         91);
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
/*     */   public void setTime(int paramInt, Time paramTime) throws SQLException {
/* 208 */     GregorianCalendar gregorianCalendar = new GregorianCalendar();
/* 209 */     gregorianCalendar.setTime(paramTime);
/* 210 */     setparm(paramInt, 
/* 211 */         String.valueOf((gregorianCalendar.get(10) < 10) ? "0" : "") + 
/* 212 */         Integer.toString(gregorianCalendar.get(10)) + ":" + (
/* 213 */         (gregorianCalendar.get(12) < 10) ? "0" : "") + 
/* 214 */         Integer.toString(gregorianCalendar.get(12)) + ":" + (
/* 215 */         (gregorianCalendar.get(13) < 10) ? "0" : "") + 
/* 216 */         Integer.toString(gregorianCalendar.get(13)), 
/* 217 */         92);
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
/*     */   public void setTimestamp(int paramInt, Timestamp paramTimestamp) throws SQLException {
/* 232 */     setparm(paramInt, paramTimestamp, 93);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnicodeStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearParameters() throws SQLException {
/* 264 */     this.parms = new Vector();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int paramInt1, Object paramObject, int paramInt2) throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int paramInt1, Object paramObject, int paramInt2, int paramInt3) throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int paramInt, Object paramObject) throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute() throws SQLException {
/* 284 */     return execute(prepareQuery());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGPreparedStatement.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */