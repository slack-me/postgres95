/*    */ package postgres95;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PGNotify
/*    */ {
/*    */   int pid;
/*    */   String name;
/*    */   
/*    */   PGNotify(int paramInt, byte[] paramArrayOfbyte) {
/* 25 */     this.pid = paramInt;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     this.name = new String(paramArrayOfbyte);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGNotify.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */