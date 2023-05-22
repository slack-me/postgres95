/*     */ package postgres95;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.Driver;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.DriverPropertyInfo;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Properties;
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
/*     */ public class PGDriver
/*     */   implements Driver
/*     */ {
/*     */   static final int MAJORVERSION = 1;
/*     */   static final int MINORVERSION = 1;
/*  26 */   static Vector connections = new Vector();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  33 */       DriverManager.registerDriver(new PGDriver()); return;
/*  34 */     } catch (Exception exception) {
/*     */       return;
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
/*     */   public Connection connect(String paramString, Properties paramProperties) throws SQLException {
/*  72 */     String str1 = null;
/*  73 */     String str2 = null;
/*  74 */     String str3 = null;
/*  75 */     int i = paramString.indexOf(':');
/*     */     
/*  77 */     if (i == -1) {
/*  78 */       return null;
/*     */     }
/*  80 */     if (paramString.substring(0, i).compareTo("jdbc") != 0) {
/*  81 */       return null;
/*     */     }
/*  83 */     paramString = paramString.substring(i + 1);
/*     */     
/*  85 */     i = paramString.indexOf(':');
/*  86 */     if (i == -1) {
/*  87 */       return null;
/*     */     }
/*  89 */     if (paramString.substring(0, i).compareTo("postgres95") != 0) {
/*  90 */       return null;
/*     */     }
/*  92 */     paramString = paramString.substring(i + 1);
/*  93 */     if (paramString.substring(0, 2).compareTo("//") == 0) {
/*  94 */       paramString = paramString.substring(2);
/*  95 */       i = paramString.indexOf('/');
/*  96 */       if (i == -1) {
/*  97 */         str1 = paramString;
/*     */       } else {
/*  99 */         str1 = paramString.substring(0, i);
/* 100 */         str3 = paramString.substring(i + 1);
/*     */       } 
/* 102 */       i = str1.indexOf(':');
/* 103 */       if (i != -1) {
/* 104 */         str2 = str1.substring(i + 1);
/* 105 */         str1 = str1.substring(0, i);
/*     */       } 
/*     */     } else {
/* 108 */       str3 = paramString;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     String str4 = paramProperties.getProperty("PGHOST");
/* 115 */     String str5 = paramProperties.getProperty("PGPORT");
/* 116 */     String str6 = paramProperties.getProperty("PGOPTIONS");
/* 117 */     String str7 = paramProperties.getProperty("PGTTY");
/* 118 */     String str8 = paramProperties.getProperty("user");
/* 119 */     String str9 = paramProperties.getProperty("password");
/*     */ 
/*     */     
/* 122 */     if (str1 != null) {
/* 123 */       str4 = str1;
/*     */     }
/* 125 */     if (str2 != null) {
/* 126 */       str5 = str2;
/*     */     }
/*     */     
/* 129 */     if (str4 == null) {
/* 130 */       str4 = "localhost";
/*     */     }
/* 132 */     if (str5 == null) {
/* 133 */       str5 = "5432";
/*     */     }
/* 135 */     if (str6 == null) {
/* 136 */       str6 = "";
/*     */     }
/* 138 */     if (str7 == null) {
/* 139 */       str7 = "";
/*     */     }
/* 141 */     if (str3 == null) {
/* 142 */       return null;
/*     */     }
/* 144 */     PGConnection pGConnection = new PGConnection(this, str4, str5, str6, str7, str3, str8, str9);
/*     */ 
/*     */     
/* 147 */     connections.addElement(pGConnection);
/*     */     
/* 149 */     return pGConnection;
/*     */   }
/*     */ 
/*     */   
/*     */   void closeConnection(PGConnection paramPGConnection) {
/* 154 */     connections.removeElement(paramPGConnection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMajorVersion() {
/* 161 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMinorVersion() {
/* 166 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean acceptsURL(String paramString) throws SQLException {
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public DriverPropertyInfo[] getPropertyInfo(String paramString, Properties paramProperties) throws SQLException {
/* 176 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jdbcCompliant() {
/* 182 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGDriver.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */