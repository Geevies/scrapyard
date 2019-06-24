/*    */ package gogga;
/*    */ 
/*    */ import java.awt.geom.Point2D.Double;
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
/*    */ public class LineGraph
/*    */   extends Graphable
/*    */ {
/*    */   protected double gradient;
/*    */   protected double intercept;
/*    */   
/*    */   public LineGraph()
/*    */   {
/* 24 */     super((byte)0);this.gradient = 1.0D;this.intercept = 0.0D;
/*    */   }
/*    */   
/*    */ 
/*    */   public LineGraph(double paramDouble1, double paramDouble2)
/*    */   {
/* 30 */     super((byte)0);this.gradient = 1.0D;this.intercept = 0.0D;
/* 31 */     this.gradient = paramDouble1;
/* 32 */     this.intercept = paramDouble2;
/* 33 */     Graphable.grapher.pushChanges();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void setGradient(double paramDouble)
/*    */   {
/* 42 */     this.gradient = paramDouble;
/* 43 */     Graphable.grapher.pushChanges();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void setIntercept(double paramDouble)
/*    */   {
/* 52 */     this.intercept = paramDouble;
/* 53 */     Graphable.grapher.pushChanges();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void setLinearParams(double paramDouble1, double paramDouble2)
/*    */   {
/* 63 */     this.gradient = paramDouble1;
/* 64 */     this.intercept = paramDouble2;
/* 65 */     Graphable.grapher.pushChanges();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected final void evaluateXY(Point2D.Double paramDouble)
/*    */   {
/* 77 */     paramDouble.y = (this.gradient * paramDouble.x + this.intercept);
/*    */   }
/*    */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\LineGraph.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */