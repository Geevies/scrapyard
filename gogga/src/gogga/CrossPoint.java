/*    */ package gogga;
/*    */ 
/*    */ import java.awt.Graphics;
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
/*    */ public final class CrossPoint
/*    */   extends PointShape
/*    */ {
/*    */   public CrossPoint(byte paramByte)
/*    */   {
/* 21 */     super(paramByte);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CrossPoint() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public final void drawPoint(Graphics paramGraphics, int paramInt1, int paramInt2)
/*    */   {
/* 32 */     paramGraphics.drawLine(paramInt1, paramInt2 - this.height / 2, paramInt1, paramInt2 + this.height / 2);
/* 33 */     paramGraphics.drawLine(paramInt1 - this.width / 2, paramInt2, paramInt1 + this.width / 2, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\CrossPoint.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */