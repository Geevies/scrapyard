/*     */ package gogga;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.ComponentListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
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
/*     */ public class GraphPanel
/*     */   extends JPanel
/*     */ {
/*     */   public static final byte XMIN = 0;
/*     */   public static final byte XMAX = 1;
/*     */   public static final byte YMIN = 2;
/*     */   public static final byte YMAX = 3;
/*     */   public static final byte XAXISLABEL = 4;
/*     */   public static final byte YAXISLABEL = 5;
/*     */   public static final int OFFSETX = 40;
/*     */   public static final int OFFSETY = 40;
/*     */   private JFrame controller;
/*     */   public int width;
/*     */   public int height;
/*     */   public double xFullScale;
/*     */   public double yFullScale;
/*     */   public double xPixelIncrement;
/*     */   public double yPixelIncrement;
/*     */   private int originX;
/*     */   private int originY;
/*     */   private Image backBufferImage;
/*     */   private Graphics backBuffer;
/*     */   public Color BORDER;
/*     */   protected Color borderColour;
/*     */   protected Color backgroundColour;
/*     */   protected boolean sizeOK;
/*     */   public double xMin;
/*     */   public double xMax;
/*     */   public double yMin;
/*     */   public double yMax;
/*     */   public boolean showAxisLabels;
/*     */   public String xAxisLabel;
/*     */   public String yAxisLabel;
/*     */   public int numTicks;
/*     */   protected GraphVector theGraphs;
/*     */   
/*     */   public GraphPanel(JFrame paramJFrame)
/*     */   {
/* 146 */     this.BORDER = new Color(238, 238, 255);this.sizeOK = true;this.xMin = -5.0D;this.xMax = 5.0D;this.yMin = -5.0D;this.yMax = 5.0D;this.showAxisLabels = true;this.xAxisLabel = "X";this.yAxisLabel = "Y";this.numTicks = 4;
/*     */     
/* 148 */     this.controller = paramJFrame;
/*     */     
/*     */ 
/* 151 */     this.borderColour = this.BORDER;
/* 152 */     this.backgroundColour = Color.white;
/*     */     
/*     */ 
/* 155 */     if (this == null) throw null; addComponentListener(new ResizeListener());
/*     */     
/*     */ 
/*     */ 
/* 159 */     if (this == null) throw null; this.theGraphs = new GraphVector();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBorderColour(Color paramColor)
/*     */   {
/* 168 */     this.borderColour = paramColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBackgroundColour(Color paramColor)
/*     */   {
/* 178 */     this.backgroundColour = paramColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addGraph(Graphable paramGraphable)
/*     */   {
/* 188 */     this.theGraphs.addElement(paramGraphable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeGraph(Graphable paramGraphable)
/*     */   {
/* 199 */     return this.theGraphs.removeElement(paramGraphable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void deleteAllGraphs()
/*     */   {
/* 207 */     this.theGraphs.deleteAllGraphs();
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
/*     */   public final boolean setAxisValue(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
/*     */   {
/* 223 */     if ((paramDouble1 > paramDouble2) || (paramDouble3 > paramDouble4)) {
/* 224 */       return false;
/*     */     }
/* 226 */     this.xMin = paramDouble1;
/* 227 */     this.xMax = paramDouble2;
/* 228 */     this.yMin = paramDouble3;
/* 229 */     this.yMax = paramDouble4;
/*     */     
/*     */ 
/*     */ 
/* 233 */     repaint();
/*     */     
/* 235 */     return true;
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
/*     */   public final boolean setAxisValue(double paramDouble, byte paramByte)
/*     */   {
/* 254 */     switch (paramByte) {
/* 255 */     case 0:  if (paramDouble < this.xMax) {
/* 256 */         this.xMin = paramDouble;repaint();return true;
/*     */       }
/* 258 */       break;
/*     */     case 1: 
/* 260 */       if (paramDouble > this.xMin) {
/* 261 */         this.xMax = paramDouble;repaint();return true;
/*     */       }
/* 263 */       break;
/*     */     case 2: 
/* 265 */       if (paramDouble < this.yMax) {
/* 266 */         this.yMin = paramDouble;repaint();return true;
/*     */       }
/* 268 */       break;
/*     */     case 3: 
/* 270 */       if (paramDouble > this.yMin) {
/* 271 */         this.yMax = paramDouble;repaint();return true;
/*     */       }
/* 273 */       break;
/*     */     }
/*     */     
/* 276 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double[] getAxisValues()
/*     */   {
/* 285 */     double[] arrayOfDouble = { this.xMin, this.xMax, this.yMin, this.yMax };
/* 286 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setShowAxisLabels(boolean paramBoolean)
/*     */   {
/* 295 */     this.showAxisLabels = paramBoolean;
/* 296 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAxisLabel(String paramString, byte paramByte)
/*     */   {
/* 307 */     switch (paramByte) {
/*     */     case 4: 
/* 309 */       this.xAxisLabel = paramString;repaint(); break;
/* 310 */     case 5:  this.yAxisLabel = paramString;repaint(); break;
/*     */     }
/*     */     
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
/*     */   public void paint(Graphics paramGraphics)
/*     */   {
/* 335 */     this.width = getSize().width;
/* 336 */     this.height = getSize().height;
/*     */     
/*     */ 
/* 339 */     checkAxisMetrics();
/*     */     
/*     */ 
/*     */ 
/* 343 */     if (this.backBufferImage == null)
/*     */     {
/* 345 */       this.backBufferImage = createImage(this.width, this.height);
/* 346 */       this.backBuffer = this.backBufferImage.getGraphics();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 351 */     this.backBuffer.setClip(0, 0, this.width, this.height);
/*     */     
/*     */ 
/* 354 */     if (!this.sizeOK)
/*     */     {
/* 356 */       paramGraphics.setColor(Color.red);
/* 357 */       paramGraphics.fillRect(0, 0, this.width, this.height);
/* 358 */       paramGraphics.setColor(Color.yellow);
/* 359 */       paramGraphics.drawString("Too small...", 5, 15);
/* 360 */       return;
/*     */     }
/*     */     
/*     */ 
/* 364 */     this.backBuffer.setColor(this.BORDER);
/* 365 */     this.backBuffer.fillRect(0, 0, this.width, this.height);
/*     */     
/*     */ 
/*     */ 
/* 369 */     drawAxes(this.backBuffer);
/*     */     
/*     */ 
/*     */ 
/* 373 */     this.backBuffer.translate(40, 40);
/* 374 */     this.backBuffer.setClip(0, 0, this.width, this.height - 80);
/*     */     
/*     */ 
/*     */ 
/* 378 */     Enumeration localEnumeration = this.theGraphs.getGraphs();
/* 379 */     while (localEnumeration.hasMoreElements()) {
/* 380 */       ((Graphable)localEnumeration.nextElement()).drawGraph(this.backBuffer, this);
/*     */     }
/* 382 */     this.backBuffer.translate(-40, -40);
/*     */     
/*     */ 
/*     */ 
/* 386 */     paramGraphics.drawImage(this.backBufferImage, 0, 0, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final void checkAxisMetrics()
/*     */   {
/* 396 */     if (this.xMin >= this.xMax) {
/* 397 */       this.xMin = -5.0D;
/* 398 */       this.xMax = 5.0D;
/*     */     }
/*     */     
/* 401 */     if (this.yMin >= this.yMax) {
/* 402 */       this.yMin = -5.0D;
/* 403 */       this.yMax = 5.0D;
/*     */     }
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
/*     */   private final void drawAxes(Graphics paramGraphics)
/*     */   {
/* 422 */     this.xFullScale = (this.xMax - this.xMin);
/* 423 */     this.xPixelIncrement = (this.xFullScale / (this.width - 80));
/*     */     
/*     */ 
/* 426 */     this.yFullScale = (this.yMax - this.yMin);
/* 427 */     this.yPixelIncrement = (this.yFullScale / (this.height - 80));
/*     */     
/*     */ 
/*     */ 
/* 431 */     if ((this.xMin < 0.0D) && (this.xMax < 0.0D)) {
/* 432 */       this.originX = ((int)(this.xFullScale / this.xPixelIncrement));
/*     */     }
/* 434 */     else if ((this.xMin > 0.0D) && (this.xMax > 0.0D)) {
/* 435 */       this.originX = 0;
/*     */     } else {
/* 437 */       this.originX = ((int)(-this.xMin / this.xPixelIncrement));
/*     */     }
/*     */     
/*     */ 
/* 441 */     if ((this.yMin < 0.0D) && (this.yMax < 0.0D)) {
/* 442 */       this.originY = ((int)(this.yFullScale / this.yPixelIncrement));
/*     */     }
/* 444 */     else if ((this.yMin > 0.0D) && (this.yMax > 0.0D)) {
/* 445 */       this.originY = 0;
/*     */     } else {
/* 447 */       this.originY = ((int)(-this.yMin / this.yPixelIncrement));
/*     */     }
/*     */     
/*     */ 
/* 451 */     paramGraphics.setColor(this.backgroundColour);
/* 452 */     paramGraphics.fillRect(40, 40, this.width - 80, this.height - 80);
/* 453 */     paramGraphics.setColor(Color.black);
/*     */     
/*     */ 
/* 456 */     paramGraphics.drawLine(40, this.height - this.originY - 40, this.width - 40, this.height - this.originY - 40);
/*     */     
/*     */ 
/* 459 */     paramGraphics.drawLine(this.originX + 40, this.height - 40, this.originX + 40, 40);
/*     */     
/*     */ 
/* 462 */     if (this.showAxisLabels)
/*     */     {
/* 464 */       i = this.xAxisLabel.length();
/* 465 */       if (i > 5) {
/* 466 */         paramGraphics.drawString(this.xAxisLabel, this.width - 40 - i * 3, this.height - this.originY - 40 - 2);
/*     */       } else
/* 468 */         paramGraphics.drawString(this.xAxisLabel, this.width - 40 + 10, this.height - this.originY - 40 - 2);
/* 469 */       int j = this.yAxisLabel.length();
/* 470 */       paramGraphics.drawString(this.yAxisLabel, this.originX + 40 - j * 3, 25);
/*     */     }
/*     */     
/*     */ 
/* 474 */     int i = 10;
/*     */     
/*     */ 
/*     */ 
/* 478 */     if (this.numTicks <= 0) {
/* 479 */       this.numTicks = 1;
/*     */     }
/*     */     
/* 482 */     double d1 = this.xFullScale / this.numTicks / this.xPixelIncrement;
/*     */     
/*     */ 
/* 485 */     double d2 = this.yFullScale / this.numTicks / this.yPixelIncrement;
/*     */     
/*     */ 
/*     */ 
/* 489 */     Rectangle localRectangle = new Rectangle(0, 0, this.width, this.height);
/*     */     
/*     */ 
/*     */ 
/* 493 */     for (int k = 0; k <= this.numTicks; k++)
/*     */     {
/*     */ 
/* 496 */       int m = (int)(40.0D + d1 * k);
/*     */       
/* 498 */       paramGraphics.drawLine(m, this.height - this.originY - 40, m, this.height - this.originY - 40 + 10);
/*     */       
/*     */ 
/*     */ 
/* 502 */       paramGraphics.setClip(m, this.height - this.originY - 40, (int)d1 - 10, 20);
/* 503 */       paramGraphics.drawString(String.valueOf(this.xMin + k * (this.xFullScale / this.numTicks)), m, this.height - this.originY - 40 + 20);
/* 504 */       paramGraphics.setClip(localRectangle);
/*     */       
/*     */ 
/* 507 */       int n = (int)(40.0D + d2 * k);
/*     */       
/* 509 */       paramGraphics.drawLine(this.originX + 40 - 10, n, this.originX + 40, n);
/*     */       
/*     */ 
/*     */ 
/* 513 */       paramGraphics.drawString(String.valueOf(this.yMax - k * (this.yFullScale / this.numTicks)), this.originX, n);
/*     */       
/* 515 */       paramGraphics.setClip(localRectangle);
/*     */     }
/*     */   }
/*     */   
/*     */   public final Enumeration getGraphs()
/*     */   {
/* 521 */     return this.theGraphs.getGraphs();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final void drawErrorMessage(Graphics paramGraphics)
/*     */   {
/* 532 */     paramGraphics.setColor(Color.red);
/* 533 */     paramGraphics.fillRect(0, 0, this.width, this.height);
/* 534 */     paramGraphics.setColor(Color.yellow);
/* 535 */     paramGraphics.drawString("Can't draw at this size", 10, 10);
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
/*     */   public void addGraphListener(XYValWatcher paramXYValWatcher)
/*     */   {
/* 548 */     addMouseMotionListener(new GraphListener(this, paramXYValWatcher));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class ResizeListener
/*     */     implements ComponentListener
/*     */   {
/*     */     public void componentResized(ComponentEvent paramComponentEvent)
/*     */     {
/*     */       try
/*     */       {
/* 565 */         GraphPanel.this.sizeOK = true;
/* 566 */         if ((GraphPanel.this.getSize().width > 80) && (GraphPanel.this.getSize().height > 80)) {
/* 567 */           GraphPanel.this.backBufferImage = GraphPanel.this.createImage(GraphPanel.this.getSize().width, GraphPanel.this.getSize().height);
/* 568 */           GraphPanel.this.backBuffer = GraphPanel.this.backBufferImage.getGraphics();
/*     */         }
/*     */         else {
/* 571 */           GraphPanel.this.sizeOK = false;
/*     */         }
/*     */       } catch (Exception localException) {
/* 574 */         System.err.println("Can't create a backbuffer for drawing, using old one");
/*     */       }
/*     */     }
/*     */     
/*     */     public void componentMoved(ComponentEvent paramComponentEvent) {}
/*     */     
/*     */     public void componentShown(ComponentEvent paramComponentEvent) {}
/*     */     
/*     */     public void componentHidden(ComponentEvent paramComponentEvent) {}
/*     */     
/*     */     ResizeListener() {}
/*     */   }
/*     */   
/*     */   private class GraphVector
/*     */   {
/* 589 */     private Vector graphs = new Vector();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void addElement(Graphable paramGraphable)
/*     */     {
/* 599 */       this.graphs.addElement(paramGraphable);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean removeElement(Graphable paramGraphable)
/*     */     {
/* 609 */       return this.graphs.removeElement(paramGraphable);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void deleteAllGraphs()
/*     */     {
/* 616 */       this.graphs.removeAllElements();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Enumeration getGraphs()
/*     */     {
/* 625 */       return this.graphs.elements();
/*     */     }
/*     */     
/*     */     GraphVector() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\GraphPanel.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */