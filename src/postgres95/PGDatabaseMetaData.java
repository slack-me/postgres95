/*      */ package postgres95;
/*      */ 
/*      */ import java.sql.DatabaseMetaData;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Vector;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PGDatabaseMetaData
/*      */   implements DatabaseMetaData
/*      */ {
/*      */   PGConnection conn;
/*      */   int procedureResultUnknown;
/*      */   int procedureNoResult;
/*      */   int procedureReturnsResult;
/*      */   int procedureColumnUnknown;
/*      */   int procedureColumnIn;
/*      */   int procedureColumnInOut;
/*      */   int procedureColumnOut;
/*      */   int procedureColumnReturn;
/*      */   int procedureColumnResult;
/*      */   int procedureNoNulls;
/*      */   int procedureNullable;
/*      */   int procedureNullableUnknown;
/*      */   int columnNoNulls;
/*      */   int columnNullable;
/*      */   int columnNullableUnknown;
/*      */   int bestRowTemporary;
/*      */   int bestRowTransaction;
/*      */   int bestRowSession;
/*      */   int bestRowUnknown;
/*      */   int bestRowNotPseudo;
/*      */   int bestRowPseudo;
/*      */   int versionColumnUnknown;
/*      */   int versionColumnNotPseudo;
/*      */   int versionColumnPseudo;
/*      */   int importedKeyCascade;
/*      */   int importedKeyRestrict;
/*      */   int importedKeySetNull;
/*      */   int typeNoNulls;
/*      */   int typeNullable;
/*      */   int typeNullableUnknown;
/*      */   int typePredNone;
/*      */   int typePredChar;
/*      */   int typePredBasic;
/*      */   int typeSearchable;
/*      */   short tableIndexStatistic;
/*      */   short tableIndexClustered;
/*      */   short tableIndexHashed;
/*      */   short tableIndexOther;
/*      */   
/*      */   public PGDatabaseMetaData(PGConnection paramPGConnection) {
/* 1251 */     this.procedureNoResult = 1;
/*      */ 
/*      */ 
/*      */     
/* 1255 */     this.procedureReturnsResult = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1326 */     this.procedureColumnIn = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1331 */     this.procedureColumnInOut = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1336 */     this.procedureColumnOut = 4;
/*      */ 
/*      */ 
/*      */     
/* 1340 */     this.procedureColumnReturn = 5;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1345 */     this.procedureColumnResult = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1355 */     this.procedureNullable = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1360 */     this.procedureNullableUnknown = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1587 */     this.columnNullable = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1592 */     this.columnNullableUnknown = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1707 */     this.bestRowTransaction = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1712 */     this.bestRowSession = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1722 */     this.bestRowNotPseudo = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1727 */     this.bestRowPseudo = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1770 */     this.versionColumnNotPseudo = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1775 */     this.versionColumnPseudo = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1885 */     this.importedKeyRestrict = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1891 */     this.importedKeySetNull = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2067 */     this.typeNullable = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2072 */     this.typeNullableUnknown = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2082 */     this.typePredChar = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2087 */     this.typePredBasic = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2092 */     this.typeSearchable = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2159 */     this.tableIndexClustered = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2164 */     this.tableIndexHashed = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2169 */     this.tableIndexOther = 3;
/*      */     this.conn = paramPGConnection;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean allProceduresAreCallable() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean allTablesAreSelectable() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   private int SQLType(int paramInt) {
/* 2183 */     switch (paramInt) {
/*      */ 
/*      */       
/*      */       case 16:
/* 2187 */         return -7;
/*      */ 
/*      */       
/*      */       case 18:
/*      */       case 20:
/*      */       case 409:
/*      */       case 410:
/*      */       case 411:
/* 2195 */         return 1;
/*      */       
/*      */       case 21:
/*      */       case 810:
/* 2199 */         return 5;
/*      */       
/*      */       case 23:
/*      */       case 26:
/*      */       case 27:
/*      */       case 28:
/*      */       case 29:
/*      */       case 30:
/*      */       case 910:
/* 2208 */         return 4;
/*      */       
/*      */       case 700:
/* 2211 */         return 6;
/*      */       
/*      */       case 701:
/* 2214 */         return 8;
/*      */       
/*      */       case 19:
/*      */       case 25:
/*      */       case 605:
/*      */       case 911:
/* 2220 */         return -1;
/*      */       
/*      */       case 1043:
/* 2223 */         return 12;
/*      */       
/*      */       case 1082:
/* 2226 */         return 91;
/*      */       
/*      */       case 1083:
/* 2229 */         return 92;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 17:
/*      */       case 600:
/*      */       case 601:
/*      */       case 602:
/*      */       case 603:
/*      */       case 604:
/* 2244 */         return 1111;
/*      */ 
/*      */       
/*      */       case 22:
/*      */       case 702:
/*      */       case 703:
/*      */       case 704:
/*      */       case 705:
/* 2252 */         return 0;
/*      */     } 
/*      */     
/* 2255 */     return 0;
/*      */   }
/*      */   
/*      */   public String getURL() throws SQLException {
/*      */     return "jdbc:postgres95://" + this.conn.Host + ":" + this.conn.Port + "/" + this.conn.Dbname;
/*      */   }
/*      */   
/*      */   public String getUserName() throws SQLException {
/*      */     return this.conn.User;
/*      */   }
/*      */   
/*      */   public boolean isReadOnly() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean nullsAreSortedHigh() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean nullsAreSortedLow() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean nullsAreSortedAtStart() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean nullsAreSortedAtEnd() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public String getDatabaseProductName() throws SQLException {
/*      */     return "Postgres95";
/*      */   }
/*      */   
/*      */   public String getDatabaseProductVersion() throws SQLException {
/*      */     return "1.0";
/*      */   }
/*      */   
/*      */   public String getDriverName() throws SQLException {
/*      */     return "PGDriver";
/*      */   }
/*      */   
/*      */   public String getDriverVersion() throws SQLException {
/*      */     return String.valueOf(this.conn.parent.getMajorVersion()) + "." + this.conn.parent.getMinorVersion();
/*      */   }
/*      */   
/*      */   public int getDriverMajorVersion() {
/*      */     return this.conn.parent.getMajorVersion();
/*      */   }
/*      */   
/*      */   public int getDriverMinorVersion() {
/*      */     return this.conn.parent.getMinorVersion();
/*      */   }
/*      */   
/*      */   public boolean usesLocalFiles() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean usesLocalFilePerTable() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsMixedCaseIdentifiers() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean storesUpperCaseIdentifiers() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean storesLowerCaseIdentifiers() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean storesMixedCaseIdentifiers() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public String getIdentifierQuoteString() throws SQLException {
/*      */     return "\"";
/*      */   }
/*      */   
/*      */   public String getSQLKeywords() throws SQLException {
/*      */     return "";
/*      */   }
/*      */   
/*      */   public String getNumericFunctions() throws SQLException {
/*      */     return "";
/*      */   }
/*      */   
/*      */   public String getStringFunctions() throws SQLException {
/*      */     return "";
/*      */   }
/*      */   
/*      */   public String getSystemFunctions() throws SQLException {
/*      */     return "";
/*      */   }
/*      */   
/*      */   public String getTimeDateFunctions() throws SQLException {
/*      */     return "";
/*      */   }
/*      */   
/*      */   public String getSearchStringEscape() throws SQLException {
/*      */     return "\\";
/*      */   }
/*      */   
/*      */   public String getExtraNameCharacters() throws SQLException {
/*      */     return "";
/*      */   }
/*      */   
/*      */   public boolean supportsAlterTableWithAddColumn() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsAlterTableWithDropColumn() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsColumnAliasing() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean nullPlusNonNullIsNull() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsConvert() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsConvert(int paramInt1, int paramInt2) throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsTableCorrelationNames() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsDifferentTableCorrelationNames() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsExpressionsInOrderBy() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsOrderByUnrelated() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsGroupBy() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsGroupByUnrelated() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsGroupByBeyondSelect() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsLikeEscapeClause() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsMultipleResultSets() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsMultipleTransactions() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsNonNullableColumns() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsMinimumSQLGrammar() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsCoreSQLGrammar() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsExtendedSQLGrammar() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsANSI92EntryLevelSQL() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsANSI92IntermediateSQL() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsANSI92FullSQL() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsIntegrityEnhancementFacility() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsOuterJoins() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsFullOuterJoins() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsLimitedOuterJoins() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public String getSchemaTerm() throws SQLException {
/*      */     return "schema";
/*      */   }
/*      */   
/*      */   public String getProcedureTerm() throws SQLException {
/*      */     return "procedure";
/*      */   }
/*      */   
/*      */   public String getCatalogTerm() throws SQLException {
/*      */     return "catalog";
/*      */   }
/*      */   
/*      */   public boolean isCatalogAtStart() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public String getCatalogSeparator() throws SQLException {
/*      */     return ".";
/*      */   }
/*      */   
/*      */   public boolean supportsSchemasInDataManipulation() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsSchemasInProcedureCalls() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsSchemasInTableDefinitions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsSchemasInIndexDefinitions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsCatalogsInDataManipulation() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsCatalogsInProcedureCalls() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsCatalogsInTableDefinitions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsPositionedDelete() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsPositionedUpdate() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsSelectForUpdate() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsStoredProcedures() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsSubqueriesInComparisons() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsSubqueriesInExists() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsSubqueriesInIns() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsSubqueriesInQuantifieds() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsCorrelatedSubqueries() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsUnion() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsUnionAll() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public int getMaxBinaryLiteralLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxCharLiteralLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxColumnNameLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxColumnsInGroupBy() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxColumnsInIndex() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxColumnsInOrderBy() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxColumnsInSelect() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxColumnsInTable() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxConnections() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxCursorNameLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxIndexLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxSchemaNameLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxProcedureNameLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxCatalogNameLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxRowSize() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
/*      */     return true;
/*      */   }
/*      */   
/*      */   public int getMaxStatementLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxStatements() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxTableNameLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxTablesInSelect() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getMaxUserNameLength() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public int getDefaultTransactionIsolation() throws SQLException {
/*      */     return 0;
/*      */   }
/*      */   
/*      */   public boolean supportsTransactions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsTransactionIsolationLevel(int paramInt) throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
/*      */     return false;
/*      */   }
/*      */   
/*      */   public ResultSet getProcedures(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getProcedureColumns(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getTables(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) throws SQLException {
/*      */     return this.conn.createStatement().executeQuery("SELECT '' as TABLE_CAT,'' AS TABLE_SCHEM,relname AS TABLE_NAME,'TABLE' AS TABLE_TYPE,'' AS REMARKS FROM pg_class WHERE relkind = 'r'  and relname !~ '^pg_'  and relname !~ '^Inv'  and relname ~ '" + paramString3 + "' " + "ORDER BY TABLE_NAME;");
/*      */   }
/*      */   
/*      */   public ResultSet getSchemas() throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getCatalogs() throws SQLException {
/*      */     return this.conn.createStatement().executeQuery("SELECT '' as TABLE_CAT,'' AS TABLE_SCHEM,relname AS TABLE_NAME,'table' AS TABLE_TYPE,'' AS REMARKS FROM pg_class WHERE relkind = 'r'   and relname !~ '^pg_'   and relname !~ '^Inv' ORDER BY TABLE_NAME;");
/*      */   }
/*      */   
/*      */   public ResultSet getTableTypes() throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getColumns(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/*      */     PGResultSet pGResultSet = (PGResultSet)this.conn.createStatement().executeQuery("SELECT '' as TABLE_CAT,'' AS TABLE_SCHEM,c.relname AS TABLE_NAME,a.attname AS COLUMN_NAME,t.oid as DATA_TYPE, t.typname as TYPE_NAME,a.attlen as COLUMN_SIZE,'' as BUFFER_LENGTH,'0' as DECIMAL_DIGITS,'10' as NUM_PREC_RADIX,'2' as NULLABLE,'' as REMARKS,'' as COLUMN_DEF,'0' as SQL_DATA_TYPE,'0' AS SQL_DATETIME_SUB,a.attlen as CHAR_OCTET_LENGTH,a.attcacheoff as ORDINAL_POSITION,'' as IS_NULLABLE  FROM pg_class c, pg_attribute a, pg_type t  WHERE relkind = 'r'   and relname ~ '" + paramString3 + "'" + "  and relname !~ '^pg_' " + "  and relname !~ '^Inv' " + "  and a.attnum > 0" + "  and a.attrelid = c.oid" + "  and a.atttypid = t.oid" + " ORDER BY TABLE_NAME, ORDINAL_POSITION;");
/*      */     try {
/*      */       int i = pGResultSet.findColumn("DATA_TYPE") - 1;
/*      */       int j = pGResultSet.tuples.size();
/*      */       for (byte b = 0; b < j; b++) {
/*      */         String str = ((Vector)pGResultSet.tuples.elementAt(b)).elementAt(i);
/*      */         ((Vector)pGResultSet.tuples.elementAt(b)).setElementAt(Integer.toString(SQLType(Integer.valueOf(str).intValue())), i);
/*      */       } 
/*      */     } catch (Exception exception) {
/*      */       pGResultSet.close();
/*      */       throw new SQLException("getColumns(): " + exception);
/*      */     } 
/*      */     return pGResultSet;
/*      */   }
/*      */   
/*      */   public ResultSet getColumnPrivileges(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getTablePrivileges(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getBestRowIdentifier(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getVersionColumns(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getPrimaryKeys(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     return this.conn.createStatement().executeQuery("SELECT '' as TABLE_CAT,'' AS TABLE_SCHEM,bc.relname AS TABLE_NAME,ic.relname AS COLUMN_NAME,'1' as KEY_SEQ,t.typname as PK_NAME  FROM pg_class bc, pg_class ic, pg_index i, pg_attribute a  WHERE relkind = 'r'   and bc.relname ~ '" + paramString3 + "'" + "  and i.indrelid = bc.oid" + "  and i.indexrelid = ic.oid" + "  and i.indkey[0] = a.attnum" + "  and i.indproc = '0'::oid" + "  and a.attrelid = bc.oid" + " ORDER BY TABLE_NAME, COLUMN_NAME;");
/*      */   }
/*      */   
/*      */   public ResultSet getImportedKeys(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getExportedKeys(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getCrossReference(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getTypeInfo() throws SQLException {
/*      */     return null;
/*      */   }
/*      */   
/*      */   public ResultSet getIndexInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2) throws SQLException {
/*      */     return null;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGDatabaseMetaData.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */