/*    */ package gogga;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.event.MouseInputAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GraphListener
/*    */   extends MouseInputAdapter
/*    */ {
/*    */   private double xVal;
/*    */   private double yVal;
/*    */   private GraphPanel graphPanel;
/*    */   private XYValWatcher listener;
/*    */   
/*    */   public GraphListener(GraphPanel paramGraphPanel, XYValWatcher paramXYValWatcher)
/*    */   {
/* 18 */     this.graphPanel = paramGraphPanel;
/* 19 */     this.listener = paramXYValWatcher;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void mouseMoved(MouseEvent paramMouseEvent)
/*    */   {
/* 26 */     if ((paramMouseEvent.getX() < 40) || (paramMouseEvent.getY() < 40) || (paramMouseEvent.getX() > this.graphPanel.width - 40) || (paramMouseEvent.getY() > this.graphPanel.height - 40))
/*    */     {
/* 28 */       this.listener.updateXYVals("-n/a-", "-n/a-");
/*    */     } else {
/* 30 */       this.xVal = ((paramMouseEvent.getX() - 40) * this.graphPanel.xPixelIncrement + this.graphPanel.xMin);
/* 31 */       this.yVal = ((this.graphPanel.height - paramMouseEvent.getY() - 40) * this.graphPanel.yPixelIncrement + this.graphPanel.yMin);
/* 32 */       this.listener.updateXYVals(String.valueOf(this.xVal), String.valueOf(this.yVal));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\GraphListener.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */