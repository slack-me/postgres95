/*     */ package postgres95;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.net.Socket;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Statement;
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
/*     */ public class PGConnection
/*     */   implements Connection
/*     */ {
/*     */   PGDriver parent;
/*     */   String Host;
/*     */   int Port;
/*     */   String Options;
/*     */   String Tty;
/*     */   String Dbname;
/*     */   String User;
/*     */   String Pass;
/*     */   DataInputStream sock_in;
/*     */   DataOutputStream sock_out;
/*     */   boolean autoCommit = true;
/*     */   boolean ReadOnly = false;
/*     */   String Catalog;
/*     */   static final int TRANSACTION_NONE = 0;
/*     */   static final int TRANSACTION_READ_UNCOMMITTED = 1;
/*     */   static final int TRANSACTION_READ_COMMITTED = 2;
/*     */   static final int TRANSACTION_REPEATABLE_READ = 3;
/*     */   static final int TRANSACTION_SERIALIZABLE = 4;
/*     */   static final int TRANSACTION_VERSIONING = 5;
/*  46 */   int transactionIsolation = 0;
/*     */   
/*     */   boolean autoClose = true;
/*     */   
/*     */   SQLWarning warning;
/*     */   
/*     */   private void connect() throws SQLException {
/*  53 */     byte[] arrayOfByte = new byte[285];
/*     */ 
/*     */     
/*  56 */     int i = this.Dbname.length();
/*  57 */     if (i > 64) i = 64;
/*     */     
/*  59 */     System.arraycopy(this.Dbname.getBytes(), 0, arrayOfByte, 8, i);
/*     */     
/*  61 */     i = this.User.length();
/*  62 */     if (i > 16) i = 16;
/*     */     
/*  64 */     System.arraycopy(this.User.getBytes(), 0, arrayOfByte, 72, i);
/*     */ 
/*     */ 
/*     */     
/*  68 */     i = this.Options.length();
/*  69 */     if (i > 64) i = 64;
/*     */     
/*  71 */     System.arraycopy(this.Options.getBytes(), 0, arrayOfByte, 88, i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     i = this.Tty.length();
/*  79 */     if (i > 64) i = 64;
/*     */     
/*  81 */     System.arraycopy(this.Tty.getBytes(), 0, arrayOfByte, 216, i);
/*     */     try {
/*  83 */       Socket socket = new Socket(this.Host, this.Port);
/*  84 */       this.sock_in = new DataInputStream(socket.getInputStream());
/*  85 */       this.sock_out = new DataOutputStream(socket.getOutputStream());
/*  86 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  87 */       DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*     */       
/*  89 */       i = 285;
/*  90 */       dataOutputStream.writeInt(i);
/*  91 */       dataOutputStream.writeInt(7);
/*  92 */       dataOutputStream.write(arrayOfByte, 8, i - 8);
/*     */       
/*  94 */       this.sock_out.write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
/*  95 */       this.sock_out.flush();
/*  96 */     } catch (Exception exception) {
/*  97 */       throw new SQLException("Server Connection Open Failed: " + exception);
/*     */     } 
/*     */     
/* 100 */     createStatement().executeQuery(" ");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   PGConnection(PGDriver paramPGDriver, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) throws SQLException {
/* 106 */     this.parent = paramPGDriver;
/*     */     
/* 108 */     this.Host = paramString1;
/* 109 */     this.Port = Integer.valueOf(paramString2).intValue();
/* 110 */     this.Options = paramString3;
/* 111 */     this.Tty = paramString4;
/* 112 */     this.Dbname = paramString5;
/* 113 */     this.User = paramString6;
/* 114 */     this.Pass = paramString7;
/*     */     
/* 116 */     connect();
/*     */   }
/*     */   
/*     */   public Statement createStatement() throws SQLException {
/* 120 */     return new PGStatement(this);
/*     */   }
/*     */   
/*     */   public PreparedStatement prepareStatement(String paramString) throws SQLException {
/* 124 */     return new PGPreparedStatement(this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String paramString) throws SQLException {
/* 130 */     return new PGCallableStatement(this, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String nativeSQL(String paramString) throws SQLException {
/* 135 */     System.out.println("nativeSQL called");
/* 136 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoCommit(boolean paramBoolean) throws SQLException {
/* 146 */     if (!this.autoCommit && paramBoolean)
/* 147 */       commit(); 
/* 148 */     this.autoCommit = paramBoolean;
/* 149 */     if (!this.autoCommit) {
/* 150 */       begin();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean getAutoCommit() throws SQLException {
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void begin() throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit() throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback() throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {
/* 176 */     if (!this.autoCommit)
/* 177 */       commit(); 
/* 178 */     this.parent.closeConnection(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() throws SQLException {
/* 185 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DatabaseMetaData getMetaData() throws SQLException {
/* 194 */     return new PGDatabaseMetaData(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean paramBoolean) throws SQLException {
/* 201 */     this.ReadOnly = paramBoolean;
/*     */   }
/*     */   public boolean isReadOnly() throws SQLException {
/* 204 */     return this.ReadOnly;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCatalog(String paramString) throws SQLException {
/* 209 */     this.Catalog = paramString;
/*     */   }
/*     */   public String getCatalog() throws SQLException {
/* 212 */     return this.Catalog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionIsolation(int paramInt) throws SQLException {
/* 222 */     if (paramInt < 0 || paramInt > 5)
/* 223 */       throw new SQLException(); 
/* 224 */     this.transactionIsolation = paramInt;
/*     */   }
/*     */   public int getTransactionIsolation() throws SQLException {
/* 227 */     return this.transactionIsolation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disableAutoClose() throws SQLException {
/* 237 */     this.autoClose = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoClose(boolean paramBoolean) throws SQLException {}
/*     */ 
/*     */   
/*     */   public boolean getAutoClose() throws SQLException {
/* 246 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 252 */     return this.warning;
/*     */   }
/*     */   public void clearWarnings() throws SQLException {
/* 255 */     this.warning = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGConnection.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */