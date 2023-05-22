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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PGd
/*    */ {
/*    */   static int i;
/*    */   
/*    */   static void h() {
/* 30 */     System.out.println("Debug: " + i++);
/*    */   }
/*    */   static void h(String paramString) {
/* 33 */     System.out.println(String.valueOf(paramString) + ": " + i++);
/*    */   }
/*    */   static void h(int paramInt) {
/* 36 */     System.out.println(String.valueOf(paramInt) + ": " + i++);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Downloads\Malicious Files identified by Auditor-20230522T081447Z-001\Malicious Files identified by Auditor\postgres95\postgres95.jar!\postgres95\PGd.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */