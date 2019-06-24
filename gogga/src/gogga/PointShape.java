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
/*    */ public abstract class PointShape
/*    */ {
/*    */   public static final byte TRIANGLE = 1;
/*    */   public static final byte CIRCLE = 2;
/*    */   public static final byte SQUARE = 3;
/*    */   public static final byte CROSS = 4;
/*    */   public static final byte NONE = 5;
/*    */   public static final byte FILLED = 17;
/*    */   public static final byte UNFILLED = 18;
/*    */   protected byte style;
/*    */   protected int width;
/*    */   protected int height;
/*    */   
/*    */   PointShape()
/*    */   {
/* 28 */     this.style = 17;this.width = 10;this.height = 10;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   PointShape(byte paramByte)
/*    */   {
/* 35 */     this.style = 17;this.width = 10;this.height = 10;
/* 36 */     this.style = (paramByte == 18 ? 18 : 17);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setSize(int paramInt1, int paramInt2)
/*    */   {
/* 45 */     this.width = paramInt1;
/* 46 */     this.height = paramInt2;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void setStyle(byte paramByte)
/*    */   {
/* 54 */     switch (paramByte) {
/* 55 */     case 17:  this.style = 17;return;
/* 56 */     case 18:  this.style = 18;return;
/*    */     }
/*    */   }
/*    */   
/*    */   public abstract void drawPoint(Graphics paramGraphics, int paramInt1, int paramInt2);
/*    */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\PointShape.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */