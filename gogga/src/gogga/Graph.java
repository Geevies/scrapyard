/*     */ package gogga;
/*     */ 
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Point2D.Double;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Graph
/*     */   extends Graphable
/*     */ {
/*     */   protected static final int X = 0;
/*     */   protected static final int Y = 1;
/*     */   protected PointVector points;
/*     */   protected Enumeration coords;
/*     */   protected PointShape shape;
/*     */   protected boolean drawPoints;
/*     */   
/*     */   public Graph()
/*     */   {
/*  28 */     super((byte)2);this.drawPoints = true;
/*  29 */     if (this == null) throw null; this.points = new PointVector();
/*  30 */     this.shape = new NoPoint();
/*  31 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Graph(double[][] paramArrayOfDouble)
/*     */   {
/*  42 */     super((byte)2);this.drawPoints = true;
/*  43 */     if (this == null) throw null; this.points = new PointVector();
/*  44 */     this.points.add(paramArrayOfDouble);
/*  45 */     this.shape = new NoPoint();
/*  46 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDrawingStyle(byte paramByte)
/*     */   {
/*  58 */     if ((paramByte == 1) && 
/*  59 */       (this.shape.getClass().getName().equals("essential.NoPoint"))) {
/*  60 */       setPointShape((byte)3);
/*  61 */       this.shape.setSize(1, 1);
/*     */     }
/*     */     
/*  64 */     super.setDrawingStyle(paramByte);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPointShape(PointShape paramPointShape)
/*     */   {
/*  73 */     this.shape = paramPointShape;
/*  74 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDrawPoints(boolean paramBoolean)
/*     */   {
/*  83 */     this.drawPoints = paramBoolean;
/*  84 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPointShape(byte paramByte)
/*     */   {
/*  93 */     switch (paramByte) {
/*  94 */     case 1:  this.shape = new TrianglePoint((byte)17);return;
/*  95 */     case 2:  this.shape = new CirclePoint((byte)17);return;
/*  96 */     case 3:  this.shape = new SquarePoint((byte)17);return;
/*  97 */     case 4:  this.shape = new CrossPoint();return;
/*  98 */     case 5:  this.shape = new NoPoint();return;
/*     */     }
/* 100 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDrawShape(boolean paramBoolean)
/*     */   {
/* 109 */     this.drawPoints = paramBoolean;
/* 110 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addPoint(Point2D.Double paramDouble)
/*     */   {
/* 119 */     this.points.addElement(paramDouble);
/* 120 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addPoint(double paramDouble1, double paramDouble2)
/*     */   {
/* 131 */     Point2D.Double localDouble = new Point2D.Double(paramDouble1, paramDouble2);
/* 132 */     this.points.addElement(localDouble);
/* 133 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void replaceElements(double[][] paramArrayOfDouble)
/*     */   {
/* 142 */     this.points.replaceElements(paramArrayOfDouble);
/* 143 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void evaluateXY(Point2D.Double paramDouble)
/*     */   {
/* 154 */     if ((this.coords == null) || (!this.coords.hasMoreElements())) {
/* 155 */       paramDouble = null;
/* 156 */       return;
/*     */     }
/*     */     
/* 159 */     Point2D.Double localDouble = (Point2D.Double)this.coords.nextElement();
/* 160 */     paramDouble.x = localDouble.x;
/* 161 */     paramDouble.y = localDouble.y;
/*     */   }
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
/*     */ 
/*     */   public void drawGraph(Graphics paramGraphics, GraphPanel paramGraphPanel)
/*     */   {
/* 176 */     double d1 = paramGraphPanel.xMin;double d2 = paramGraphPanel.yMin;double d3 = paramGraphPanel.xMax;double d4 = paramGraphPanel.yMax;double d5 = paramGraphPanel.xPixelIncrement;double d6 = paramGraphPanel.yPixelIncrement;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */     paramGraphics.setClip(0, 0, paramGraphPanel.width - 80, paramGraphPanel.height - 80);
/*     */     
/*     */ 
/* 187 */     this.coords = this.points.getPoints();
/*     */     
/*     */ 
/* 190 */     int i = 0;int j = 0;int k = 0;int m = 0;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 195 */     paramGraphics.setColor(this.graphColor);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 200 */     if (this.drawingStyle == 0)
/*     */     {
/* 202 */       evaluateXY(this.p);
/*     */       
/*     */ 
/*     */ 
/* 206 */       if (this.p == null) {
/* 207 */         return;
/*     */       }
/* 209 */       i = (int)((this.p.x - d1) / d5);
/* 210 */       i = Math.abs(i);
/* 211 */       j = (int)((d4 - this.p.y) / d6);
/*     */       
/*     */ 
/*     */ 
/* 215 */       if (this.drawPoints) {
/* 216 */         this.shape.drawPoint(paramGraphics, i, j);
/*     */       }
/* 218 */       while (this.coords.hasMoreElements()) {
/* 219 */         evaluateXY(this.p);
/* 220 */         if (this.p == null) {
/* 221 */           return;
/*     */         }
/* 223 */         k = (int)((this.p.x - d1) / d5);
/* 224 */         m = (int)((d4 - this.p.y) / d6);
/*     */         
/* 226 */         paramGraphics.drawLine(i, j, k, m);
/* 227 */         if (this.drawPoints)
/* 228 */           this.shape.drawPoint(paramGraphics, k, m);
/* 229 */         i = k;
/* 230 */         j = m;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 236 */       while (this.coords.hasMoreElements()) {
/* 237 */         evaluateXY(this.p);
/* 238 */         if (this.p == null) {
/* 239 */           return;
/*     */         }
/* 241 */         i = (int)((this.p.x - d1) / d5);
/* 242 */         j = (int)((d4 - this.p.y) / d6);
/* 243 */         this.shape.drawPoint(paramGraphics, i, j);
/*     */       }
/*     */     }
/* 246 */     this.coords = null;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 251 */     if (this.drawTitle) {
/* 252 */       i -= paramGraphics.getFontMetrics().stringWidth(this.title) + 10;
/* 253 */       paramGraphics.drawString(this.title, i, j);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class PointVector
/*     */   {
/*     */     protected static final int X = 0;
/*     */     protected static final int Y = 1;
/* 262 */     private Vector points = new Vector();
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
/*     */     public void addElement(Point2D paramPoint2D)
/*     */     {
/* 275 */       this.points.addElement(paramPoint2D);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Point2D elementAt(int paramInt)
/*     */     {
/* 285 */       return (Point2D)this.points.elementAt(paramInt);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void add(double[][] paramArrayOfDouble)
/*     */     {
/* 296 */       int i = paramArrayOfDouble.length;
/*     */       
/*     */ 
/* 299 */       for (int j = 0; j < i; j++) {
/* 300 */         Point2D.Double localDouble = new Point2D.Double(paramArrayOfDouble[j][0], paramArrayOfDouble[j][1]);
/* 301 */         addElement(localDouble);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void replaceElements(double[][] paramArrayOfDouble)
/*     */     {
/* 312 */       this.points.removeAllElements();
/* 313 */       add(paramArrayOfDouble);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Enumeration getPoints()
/*     */     {
/* 322 */       return this.points.elements();
/*     */     }
/*     */     
/*     */     PointVector() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\Graph.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */