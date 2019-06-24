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
/*    */ public final class TrianglePoint
/*    */   extends PointShape
/*    */ {
/*    */   protected static final int NUMPOINTS = 3;
/*    */   private int[] xpoints;
/*    */   private int[] ypoints;
/*    */   
/*    */   public TrianglePoint()
/*    */   {
/* 22 */     this.xpoints = new int[3];
/* 23 */     this.ypoints = new int[3];
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public TrianglePoint(byte paramByte)
/*    */   {
/* 32 */     super(paramByte);
/* 33 */     this.xpoints = new int[3];
/* 34 */     this.ypoints = new int[3];
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void drawPoint(Graphics paramGraphics, int paramInt1, int paramInt2)
/*    */   {
/* 45 */     this.xpoints[0] = paramInt1;
/* 46 */     this.ypoints[0] = (paramInt2 - this.height / 2);
/*    */     
/* 48 */     this.xpoints[1] = (paramInt1 - this.width / 2);
/* 49 */     this.ypoints[1] = (paramInt2 + this.height / 2);
/*    */     
/* 51 */     this.xpoints[2] = (paramInt1 + this.width / 2);
/* 52 */     this.ypoints[2] = (paramInt2 + this.height / 2);
/*    */     
/* 54 */     switch (this.style) {
/* 55 */     case 17:  paramGraphics.fillPolygon(this.xpoints, this.ypoints, 3);return;
/* 56 */     case 18:  paramGraphics.drawPolygon(this.xpoints, this.ypoints, 3);return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\TrianglePoint.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */