/*     */ package gogga;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.geom.Point2D.Double;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.geom.RectangularShape;
/*     */ import java.io.PrintStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Graphable
/*     */ {
/*     */   public static final byte LINEAR = 0;
/*     */   public static final byte PARABOLA = 1;
/*     */   public static final byte POINT = 2;
/*     */   public static final byte TRIG = 3;
/*     */   public static final byte EXPONENTIAL = 4;
/*     */   public static GraphFrame grapher = new GraphFrame();
/*     */   public static final byte CONTINUOUS = 0;
/*     */   public static final byte PLOTPOINTS = 1;
/*     */   protected boolean drawTitle;
/*     */   protected Point2D.Double p;
/*     */   protected boolean userSetAxes;
/*     */   protected String title;
/*     */   protected Color graphColor;
/*     */   protected boolean NaN;
/*     */   protected byte mainType;
/*     */   protected byte drawingStyle;
/*     */   
/*     */   Graphable(byte paramByte)
/*     */   {
/*  90 */     this.userSetAxes = false;
/*  91 */     this.mainType = paramByte;
/*  92 */     this.drawingStyle = 0;
/*  93 */     this.p = new Point2D.Double();
/*  94 */     this.graphColor = Color.blue;
/*  95 */     this.title = "No Title";
/*  96 */     grapher.addGraph(this);
/*  97 */     grapher.pushChanges();
/*     */   }
/*     */   
/*     */   public void removeGraph()
/*     */   {
/* 102 */     grapher.removeGraph(this);
/* 103 */     grapher.pushChanges();
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
/*     */   public void setDrawingStyle(byte paramByte)
/*     */   {
/* 116 */     if (paramByte == 1) {
/* 117 */       this.drawingStyle = 1;
/* 118 */       return;
/*     */     }
/*     */     
/* 121 */     this.drawingStyle = 0;
/* 122 */     grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setAxes(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
/*     */   {
/* 134 */     grapher.setAxes(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/* 135 */     this.userSetAxes = true;
/* 136 */     grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final double[] getAxisValues()
/*     */   {
/* 146 */     return grapher.getAxisValues();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setAxisLabels(String paramString1, String paramString2)
/*     */   {
/* 156 */     grapher.setAxisLabels(paramString1, paramString2);
/* 157 */     grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setTitle(String paramString)
/*     */   {
/* 166 */     this.title = paramString;
/* 167 */     grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setDrawTitle(boolean paramBoolean)
/*     */   {
/* 176 */     this.drawTitle = paramBoolean;
/* 177 */     grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setColor(Color paramColor)
/*     */   {
/* 186 */     this.graphColor = paramColor;
/* 187 */     grapher.pushChanges();
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
/* 210 */     double d1 = paramGraphPanel.xMin;double d2 = paramGraphPanel.yMin;double d3 = paramGraphPanel.xMax;double d4 = paramGraphPanel.yMax;double d5 = paramGraphPanel.xPixelIncrement;double d6 = paramGraphPanel.yPixelIncrement;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 217 */     int i = paramGraphPanel.width - 80;
/*     */     
/* 219 */     this.p.x = d1;
/* 220 */     evaluateXY(this.p);
/*     */     
/*     */ 
/* 223 */     int j = 0;
/* 224 */     int k = (int)((d4 - this.p.y) / d6);
/* 225 */     int m = 0;int n = 0;
/*     */     
/* 227 */     paramGraphics.setColor(this.graphColor);
/*     */     
/* 229 */     for (int i1 = 0; i1 <= i; i1++) {
/* 230 */       m = i1;
/*     */       
/* 232 */       this.p.x = (d1 + i1 * d5);
/*     */       
/* 234 */       evaluateXY(this.p);
/*     */       
/* 236 */       n = (int)((d4 - this.p.y) / d6);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 241 */       if (Double.isNaN(this.p.y)) {
/* 242 */         System.out.println("NAN at " + i1);
/* 243 */         this.NaN = true;
/*     */       }
/*     */       else
/*     */       {
/* 247 */         paramGraphics.setColor(this.graphColor);
/* 248 */         if (this.NaN) {
/* 249 */           j = m;
/* 250 */           k = n;
/* 251 */           this.NaN = false;
/*     */         }
/*     */         
/*     */ 
/* 255 */         if (this.drawingStyle == 0) {
/* 256 */           paramGraphics.drawLine(j, k, m, n);
/*     */         } else {
/* 258 */           paramGraphics.drawLine(m, n, m, n);
/*     */         }
/* 260 */         j = m;
/* 261 */         k = n;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 267 */     if (this.drawTitle) {
/* 268 */       Rectangle2D localRectangle2D = paramGraphics.getFontMetrics().getStringBounds(this.title, paramGraphics);
/*     */       
/* 270 */       m = (int)(m - (localRectangle2D.getWidth() + 10.0D));
/* 271 */       n = (int)(n + (localRectangle2D.getHeight() + 10.0D));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 276 */       paramGraphics.drawString(this.title, m, n < 0 ? 10 : n);
/*     */     }
/*     */   }
/*     */   
/*     */   abstract void evaluateXY(Point2D.Double paramDouble);
/*     */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\Graphable.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */