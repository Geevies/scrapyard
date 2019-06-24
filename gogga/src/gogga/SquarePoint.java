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
/*    */ public final class SquarePoint
/*    */   extends PointShape
/*    */ {
/*    */   public SquarePoint(byte paramByte)
/*    */   {
/* 18 */     super(paramByte);
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
/* 30 */     switch (this.style) {
/* 31 */     case 17:  paramGraphics.fillRect(paramInt1 - this.width / 2, paramInt2 - this.height / 2, this.width, this.height);return;
/* 32 */     case 18:  paramGraphics.drawRect(paramInt1 - this.width / 2, paramInt2 - this.height / 2, this.width, this.height);return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\SquarePoint.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */