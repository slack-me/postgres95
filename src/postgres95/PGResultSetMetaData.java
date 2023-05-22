/*     */ package postgres95;
/*     */ 
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
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
/*     */ public class PGResultSetMetaData
/*     */   implements ResultSetMetaData
/*     */ {
/*     */   PGResultSet rs;
/*     */   int columnNoNulls;
/*     */   int columnNullable;
/*     */   int columnNullableUnknown;
/*     */   
/*     */   public int getColumnCount() throws SQLException {
/*     */     return this.rs.getColumnCount();
/*     */   }
/*     */   
/*     */   public boolean isAutoIncrement(int paramInt) throws SQLException {
/*     */     return false;
/*     */   }
/*     */   
/*     */   PGResultSetMetaData(PGResultSet paramPGResultSet) {
/*  99 */     this.columnNullable = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     this.columnNullableUnknown = 2;
/*     */     this.rs = paramPGResultSet;
/*     */   }
/*     */   
/*     */   public boolean isCaseSensitive(int paramInt) throws SQLException {
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean isSigned(int paramInt) throws SQLException {
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSearchable(int paramInt) throws SQLException {
/*     */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnDisplaySize(int paramInt) throws SQLException {
/* 123 */     return ((PGColumn)this.rs.columns.elementAt(paramInt - 1)).size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrency(int paramInt) throws SQLException {
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnLabel(int paramInt) throws SQLException {
/* 134 */     return ((PGColumn)this.rs.columns.elementAt(paramInt - 1)).name;
/*     */   }
/*     */ 
/*     */   
/*     */   public int isNullable(int paramInt) throws SQLException {
/*     */     return this.columnNullableUnknown;
/*     */   }
/*     */   
/*     */   public String getColumnName(int paramInt) throws SQLException {
/* 143 */     return ((PGColumn)this.rs.columns.elementAt(paramInt - 1)).name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchemaName(int paramInt) throws SQLException {
/* 152 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPrecision(int paramInt) throws SQLException {
/* 162 */     return ((PGColumn)this.rs.columns.elementAt(paramInt - 1)).size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScale(int paramInt) throws SQLException {
/* 172 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTableName(int paramInt) throws SQLException {
/* 181 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCatalogName(int paramInt) throws SQLException {
/* 191 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnType(int paramInt) throws SQLException {
/* 202 */     return SQLType(((PGColumn)this.rs.columns.elementAt(paramInt - 1)).oid);
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
/*     */   public String getColumnTypeName(int paramInt) throws SQLException {
/* 215 */     return SQLTypeName(((PGColumn)this.rs.columns.elementAt(paramInt - 1)).oid);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(int paramInt) throws SQLException {
/* 225 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWritable(int paramInt) throws SQLException {
/* 235 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefinitelyWritable(int paramInt) throws SQLException {
/* 245 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private int SQLType(int paramInt) {
/* 250 */     switch (paramInt) {
/*     */       case 16:
/* 252 */         return -7;
/*     */       case 18:
/* 254 */         return 1;
/*     */       case 21:
/* 256 */         return 5;
/*     */       case 23:
/* 258 */         return 4;
/*     */       case 25:
/*     */       case 1042:
/*     */       case 1043:
/* 262 */         return 12;
/*     */       case 1082:
/* 264 */         return 91;
/*     */       case 1083:
/* 266 */         return 92;
/*     */     } 
/* 268 */     return -1 * paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String SQLTypeName(int paramInt) {
/* 275 */     switch (paramInt) {
/*     */       
/*     */       case 16:
/* 278 */         return "BIT";
/*     */       
/*     */       case 18:
/* 281 */         return "CHAR";
/*     */       
/*     */       case 21:
/* 284 */         return "SMALLINT";
/*     */       
/*     */       case 23:
/* 287 */         return "INTEGER";
/*     */       
/*     */       case 1043:
/* 290 */         return "VARCHAR";
/*     */       
/*     */       case 1082:
/* 293 */         return "DATE";
/*     */       
/*     */       case 1083:
/* 296 */         return "TIME";
/*     */     } 
/* 298 */     return "OTHER";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGResultSetMetaData.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */