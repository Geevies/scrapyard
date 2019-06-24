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
/*    */ public final class CirclePoint
/*    */   extends PointShape
/*    */ {
/*    */   public CirclePoint(byte paramByte)
/*    */   {
/* 17 */     super(paramByte);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void drawPoint(Graphics paramGraphics, int paramInt1, int paramInt2)
/*    */   {
/* 29 */     switch (this.style) {
/* 30 */     case 17:  paramGraphics.fillOval(paramInt1 - this.width / 2, paramInt2 - this.height / 2, this.width, this.height);return;
/* 31 */     case 18:  paramGraphics.drawOval(paramInt1 - this.width / 2, paramInt2 - this.height / 2, this.width, this.height);return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\CirclePoint.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */