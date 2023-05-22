/*     */ package postgres95;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.Date;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGCallableStatement
/*     */   extends PGPreparedStatement
/*     */   implements CallableStatement
/*     */ {
/*     */   PGCallableStatement(PGConnection paramPGConnection, String paramString) {
/*  24 */     super(paramPGConnection, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int paramInt1, int paramInt2) throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOutParameter(int paramInt1, int paramInt2, int paramInt3) throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNull(int paramInt) throws SQLException {
/*  39 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean wasNull() throws SQLException {
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getChar(int paramInt) throws SQLException {
/*  50 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString(int paramInt) throws SQLException {
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLongVarChar(int paramInt) throws SQLException {
/*  62 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(int paramInt) throws SQLException {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getByte(int paramInt) throws SQLException {
/*  72 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getShort(int paramInt) throws SQLException {
/*  77 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(int paramInt) throws SQLException {
/*  82 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(int paramInt) throws SQLException {
/*  87 */     return 0L;
/*     */   }
/*     */   
/*     */   public float getFloat(int paramInt) throws SQLException {
/*  91 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public double getDouble(int paramInt) throws SQLException {
/*  95 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal(int paramInt1, int paramInt2) throws SQLException {
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes(int paramInt) throws SQLException {
/* 105 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBinaryStream(int paramInt) throws SQLException {
/* 110 */     return null;
/*     */   }
/*     */   
/*     */   public Date getDate(int paramInt) throws SQLException {
/* 114 */     return null;
/*     */   }
/*     */   public Time getTime(int paramInt) throws SQLException {
/* 117 */     return null;
/*     */   }
/*     */   
/*     */   public Timestamp getTimestamp(int paramInt) throws SQLException {
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DatabaseMetaData getMetaData() {
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(int paramInt) throws SQLException {
/* 137 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGCallableStatement.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */