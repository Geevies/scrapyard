/*      */ package gogga;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.awt.FileDialog;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Label;
/*      */ import java.io.DataOutputStream;
/*      */ import java.io.IOException;
/*      */ 
/*      */ public class GoggaGrid extends java.awt.Frame implements java.awt.event.ActionListener, java.awt.event.AdjustmentListener
/*      */ {
/*      */   static final int DEFAULT_XSIZE = 15;
/*      */   static final int DEFAULT_YSIZE = 10;
/*      */   int xSize;
/*      */   int ySize;
/*      */   int delayTime;
/*      */   GridCanvas gc;
/*      */   java.awt.Button saveButton;
/*      */   java.awt.Button printButton;
/*      */   java.awt.Scrollbar scrollBar;
/*      */   
/*      */   public GoggaGrid()
/*      */   {
/*   28 */     this(15, 10);
/*      */   }
/*      */   
/*      */ 
/*      */   public GoggaGrid(int paramInt1, int paramInt2)
/*      */   {
/*   34 */     super("Gogga Grid");this.delayTime = 500;
/*      */     
/*   36 */     this.xSize = paramInt1;
/*   37 */     this.ySize = paramInt2;
/*   38 */     if (this == null) throw null; this.gc = new GridCanvas(this, this.xSize, this.ySize);
/*      */     
/*      */ 
/*   41 */     if (this == null) throw null; addWindowListener(new WindowCloser());
/*      */     
/*   43 */     this.saveButton = new java.awt.Button("Save");
/*   44 */     this.printButton = new java.awt.Button("Print");
/*   45 */     this.scrollBar = new java.awt.Scrollbar(0, 50, 0, 0, 100);
/*      */     
/*      */ 
/*   48 */     this.saveButton.addActionListener(this);
/*   49 */     this.printButton.addActionListener(this);
/*      */     
/*      */ 
/*   52 */     this.scrollBar.addAdjustmentListener(this);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*   57 */     java.awt.Panel localPanel1 = new java.awt.Panel();
/*   58 */     Label localLabel1 = new Label("Slower", 2);
/*   59 */     Label localLabel2 = new Label("Faster", 0);
/*   60 */     Label localLabel3 = new Label("Set Speed", 1);
/*   61 */     Font localFont = new Font("SansSerif", 0, 10);
/*   62 */     localLabel1.setFont(localFont);
/*   63 */     localLabel2.setFont(localFont);
/*   64 */     localLabel3.setFont(localFont);
/*   65 */     localPanel1.setLayout(new java.awt.BorderLayout());
/*   66 */     localPanel1.add(localLabel1, "West");
/*   67 */     localPanel1.add(localLabel2, "East");
/*   68 */     localPanel1.add(localLabel3, "North");
/*   69 */     localPanel1.add(this.scrollBar, "Center");
/*      */     
/*      */ 
/*   72 */     java.awt.Panel localPanel2 = new java.awt.Panel();
/*   73 */     java.awt.GridBagLayout localGridBagLayout = new java.awt.GridBagLayout();
/*   74 */     java.awt.GridBagConstraints localGridBagConstraints = new java.awt.GridBagConstraints();
/*   75 */     Label localLabel4 = new Label("   ");
/*   76 */     Label localLabel5 = new Label("   ");
/*   77 */     localPanel2.setBackground(Color.lightGray);
/*   78 */     localPanel2.setLayout(localGridBagLayout);
/*      */     
/*      */ 
/*      */ 
/*   82 */     localPanel2.add(localLabel4);
/*   83 */     localPanel2.add(this.saveButton);
/*   84 */     localPanel2.add(this.printButton);
/*   85 */     localPanel2.add(localPanel1);
/*   86 */     localPanel2.add(localLabel5);
/*      */     
/*      */ 
/*   89 */     localGridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
/*   90 */     localGridBagLayout.setConstraints(this.saveButton, localGridBagConstraints);
/*   91 */     localGridBagLayout.setConstraints(this.printButton, localGridBagConstraints);
/*      */     
/*      */ 
/*      */ 
/*   95 */     localGridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
/*   96 */     localGridBagConstraints.fill = 2;
/*   97 */     localGridBagConstraints.weightx = 1.0D;
/*   98 */     localGridBagLayout.setConstraints(localPanel1, localGridBagConstraints);
/*      */     
/*      */ 
/*  101 */     add(localPanel2, "North");
/*      */     
/*  103 */     add(this.gc, "South");
/*      */     
/*  105 */     pack();
/*      */     
/*      */ 
/*  108 */     java.awt.Dimension localDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
/*  109 */     setLocation(localDimension.width - getSize().width, 0);
/*      */     
/*  111 */     show();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getXSize()
/*      */   {
/*  117 */     return this.xSize;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getYSize()
/*      */   {
/*  123 */     return this.ySize;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void drawGoggaTrail(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, int paramInt5)
/*      */   {
/*  130 */     this.gc.drawGoggaTrail(paramInt1, paramInt2, paramInt3, paramInt4, paramColor, paramInt5);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void hideGogga(int paramInt1, int paramInt2, int paramInt3, Color paramColor, String paramString)
/*      */   {
/*  137 */     this.gc.hideGogga(paramInt1, paramInt2, paramInt3, paramColor, paramString);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void showGogga(int paramInt1, int paramInt2, int paramInt3, Color paramColor, String paramString)
/*      */   {
/*  144 */     this.gc.showGogga(paramInt1, paramInt2, paramInt3, paramColor, paramString);
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  149 */       Thread.sleep(this.delayTime);
/*      */     }
/*      */     catch (InterruptedException localInterruptedException) {}
/*      */   }
/*      */   
/*      */ 
/*      */   public void actionPerformed(java.awt.event.ActionEvent paramActionEvent)
/*      */   {
/*      */     Object localObject1;
/*      */     
/*      */     Object localObject2;
/*  160 */     if (paramActionEvent.getSource() == this.saveButton)
/*      */     {
/*      */ 
/*  163 */       localObject1 = new FileDialog(this, "Save Gogga Grid", 1);
/*      */       
/*  165 */       ((FileDialog)localObject1).setFile("Gogga.bmp");
/*  166 */       ((java.awt.Dialog)localObject1).show();
/*      */       
/*  168 */       if (((FileDialog)localObject1).getFile() == null)
/*      */       {
/*  170 */         return;
/*      */       }
/*      */       
/*  173 */       localObject2 = ((FileDialog)localObject1).getDirectory() + ((FileDialog)localObject1).getFile();
/*      */       
/*  175 */       if (((String)localObject2).indexOf(".*.*") != -1)
/*      */       {
/*  177 */         localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 4);
/*      */       }
/*      */       
/*      */ 
/*  181 */       this.gc.saveToFile((String)localObject2);
/*      */     }
/*  183 */     else if (paramActionEvent.getSource() == this.printButton)
/*      */     {
/*  185 */       localObject1 = java.awt.print.PrinterJob.getPrinterJob();
/*  186 */       localObject2 = new java.awt.print.Book();
/*  187 */       ((java.awt.print.Book)localObject2).append(this.gc, new java.awt.print.PageFormat());
/*  188 */       ((java.awt.print.PrinterJob)localObject1).setPageable((java.awt.print.Pageable)localObject2);
/*  189 */       if (!((java.awt.print.PrinterJob)localObject1).printDialog())
/*      */       {
/*  191 */         return;
/*      */       }
/*      */       
/*      */       try
/*      */       {
/*  196 */         ((java.awt.print.PrinterJob)localObject1).print();
/*      */       }
/*      */       catch (java.awt.print.PrinterException localPrinterException)
/*      */       {
/*  200 */         System.err.println("Printing error: " + localPrinterException);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void adjustmentValueChanged(java.awt.event.AdjustmentEvent paramAdjustmentEvent)
/*      */   {
/*  208 */     int i = paramAdjustmentEvent.getValue();
/*      */     
/*  210 */     if (i <= 10)
/*      */     {
/*  212 */       this.delayTime = (1500 + (10 - i) * 250);
/*      */     }
/*  214 */     else if (i < 25)
/*      */     {
/*  216 */       this.delayTime = (750 + (25 - i) * 50);
/*      */     }
/*      */     else
/*      */     {
/*  220 */       this.delayTime = ((100 - i) * 10);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   class GridCanvas
/*      */     extends java.awt.Canvas
/*      */     implements java.awt.print.Printable
/*      */   {
/*      */     static final int GRID_SIZE = 25;
/*      */     
/*      */     static final int LEFT_TOP_MARGIN = 5;
/*      */     
/*      */     static final int RIGHT_BOTTOM_MARGIN = 15;
/*      */     
/*      */     static final int TEXT_MARGIN = 10;
/*      */     
/*      */     static final int ROWS_GRABBED_AT_A_TIME = 75;
/*      */     
/*      */     static final int BI_RGB = 0;
/*      */     
/*      */     static final int BI_COMPRESSED_RLE8 = 1;
/*      */     static final int BI_COMPRESSED_RLE4 = 2;
/*      */     GoggaGrid gr;
/*      */     Font gridLabelFont;
/*      */     Font goggaLabelFont;
/*      */     int textWidth;
/*      */     int textHeight;
/*      */     int canvasWidth;
/*      */     int canvasHeight;
/*      */     java.awt.Image offscreen;
/*      */     int[] goggaX;
/*      */     int[] goggaY;
/*      */     int[] goggaDirection;
/*      */     Color[] goggaColor;
/*      */     String[] goggaLabel;
/*      */     int numGoggas;
/*      */     GoggaGrid.Status status;
/*      */     DataOutputStream out;
/*      */     
/*      */     public GridCanvas(GoggaGrid paramGoggaGrid, int paramInt1, int paramInt2)
/*      */     {
/*  262 */       this.goggaX = new int[100];this.goggaY = new int[100];this.goggaDirection = new int[100];this.goggaColor = new Color[100];this.goggaLabel = new String[100];this.numGoggas = 0;
/*      */       
/*      */ 
/*  265 */       this.gr = paramGoggaGrid;
/*  266 */       this.gridLabelFont = new Font("Serif", 0, 12);
/*  267 */       FontMetrics localFontMetrics = getFontMetrics(this.gridLabelFont);
/*  268 */       this.textWidth = localFontMetrics.stringWidth("00");
/*  269 */       this.textHeight = localFontMetrics.getAscent();
/*  270 */       this.goggaLabelFont = new Font("SanSerif", 1, 10);
/*  271 */       this.canvasWidth = (25 * (paramInt1 - 1) + 5 + 15 + 10 + this.textWidth);
/*      */       
/*  273 */       this.canvasHeight = (25 * (paramInt2 - 1) + 5 + 15 + 10 + this.textHeight);
/*      */       
/*  275 */       setSize(this.canvasWidth, this.canvasHeight);
/*      */     }
/*      */     
/*      */ 
/*      */     public void paint(Graphics paramGraphics)
/*      */     {
/*  281 */       update(paramGraphics);
/*      */     }
/*      */     
/*      */ 
/*      */     public void update(Graphics paramGraphics)
/*      */     {
/*  287 */       int i = 5 + this.textWidth + 10;
/*  288 */       int j = 5 + this.textHeight + 10;
/*      */       
/*  290 */       if (this.offscreen == null)
/*      */       {
/*  292 */         initializeOffscreen();
/*      */       }
/*      */       
/*      */ 
/*  296 */       paramGraphics.drawImage(this.offscreen, 0, 0, null);
/*      */       
/*      */ 
/*  299 */       for (int k = 0; k < this.numGoggas; k++)
/*      */       {
/*  301 */         drawOneGogga(paramGraphics, i + this.goggaX[k] * 25, j + this.goggaY[k] * 25, this.goggaDirection[k], this.goggaColor[k], this.goggaLabel[k]);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private void drawOneGogga(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, Color paramColor, String paramString)
/*      */     {
/*  314 */       paramGraphics.setColor(paramColor);
/*      */       
/*      */ 
/*  317 */       if (!paramString.equals(""))
/*      */       {
/*  319 */         paramGraphics.setFont(this.goggaLabelFont);
/*  320 */         paramGraphics.drawString(paramString, paramInt1 + 10, paramInt2 - 10);
/*      */       }
/*      */       
/*  323 */       switch (paramInt3)
/*      */       {
/*      */ 
/*      */       case 1: 
/*  327 */         paramGraphics.fillOval(paramInt1 - 4, paramInt2 - 8, 8, 16);
/*  328 */         paramGraphics.setColor(Color.black);
/*  329 */         paramGraphics.drawOval(paramInt1 - 4, paramInt2 - 8, 7, 15);
/*      */         
/*  331 */         paramGraphics.setColor(Color.black);
/*  332 */         paramGraphics.drawArc(paramInt1 - 4, paramInt2 - 13, 4, 8, 135, 90);
/*  333 */         paramGraphics.drawArc(paramInt1, paramInt2 - 13, 4, 8, 315, 90);
/*  334 */         break;
/*      */       
/*      */       case 2: 
/*  337 */         paramGraphics.fillOval(paramInt1 - 4, paramInt2 - 8, 8, 16);
/*  338 */         paramGraphics.setColor(Color.black);
/*  339 */         paramGraphics.drawOval(paramInt1 - 4, paramInt2 - 8, 7, 15);
/*      */         
/*  341 */         paramGraphics.setColor(Color.black);
/*  342 */         paramGraphics.drawArc(paramInt1 - 4, paramInt2 + 5, 4, 8, 135, 120);
/*  343 */         paramGraphics.drawArc(paramInt1, paramInt2 + 5, 4, 8, 315, 90);
/*  344 */         break;
/*      */       
/*      */       case 3: 
/*  347 */         paramGraphics.fillOval(paramInt1 - 8, paramInt2 - 4, 16, 8);
/*  348 */         paramGraphics.setColor(Color.black);
/*  349 */         paramGraphics.drawOval(paramInt1 - 8, paramInt2 - 4, 15, 7);
/*      */         
/*  351 */         paramGraphics.setColor(Color.black);
/*  352 */         paramGraphics.drawArc(paramInt1 - 13, paramInt2 - 4, 8, 4, 45, 120);
/*  353 */         paramGraphics.drawArc(paramInt1 - 13, paramInt2, 8, 4, 225, 90);
/*  354 */         break;
/*      */       
/*      */       case 4: 
/*  357 */         paramGraphics.fillOval(paramInt1 - 8, paramInt2 - 4, 16, 8);
/*  358 */         paramGraphics.setColor(Color.black);
/*  359 */         paramGraphics.drawOval(paramInt1 - 8, paramInt2 - 4, 15, 7);
/*      */         
/*  361 */         paramGraphics.setColor(Color.black);
/*  362 */         paramGraphics.drawArc(paramInt1 + 4, paramInt2 - 4, 8, 4, 30, 110);
/*  363 */         paramGraphics.drawArc(paramInt1 + 5, paramInt2, 8, 4, 225, 90);
/*  364 */         break;
/*      */       }
/*      */       
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public void hideGogga(int paramInt1, int paramInt2, int paramInt3, Color paramColor, String paramString)
/*      */     {
/*  374 */       for (int i = 0; i < this.numGoggas; i++)
/*      */       {
/*  376 */         if ((paramInt1 == this.goggaX[i]) && (paramInt2 == this.goggaY[i]) && (paramInt3 == this.goggaDirection[i]) && (paramColor.equals(this.goggaColor[i])) && (paramString.equals(this.goggaLabel[i])))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  382 */           for (int j = i + 1; j < this.numGoggas; j++)
/*      */           {
/*  384 */             this.goggaX[(j - 1)] = this.goggaX[j];
/*  385 */             this.goggaY[(j - 1)] = this.goggaY[j];
/*  386 */             this.goggaDirection[(j - 1)] = this.goggaDirection[j];
/*  387 */             this.goggaColor[(j - 1)] = this.goggaColor[j];
/*  388 */             this.goggaLabel[(j - 1)] = this.goggaLabel[j];
/*      */           }
/*      */           
/*  391 */           this.numGoggas -= 1;
/*  392 */           break;
/*      */         }
/*      */       }
/*      */       
/*  396 */       repaint();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void showGogga(int paramInt1, int paramInt2, int paramInt3, Color paramColor, String paramString)
/*      */     {
/*  403 */       this.goggaX[this.numGoggas] = paramInt1;
/*  404 */       this.goggaY[this.numGoggas] = paramInt2;
/*  405 */       this.goggaDirection[this.numGoggas] = paramInt3;
/*  406 */       this.goggaColor[this.numGoggas] = paramColor;
/*  407 */       this.goggaLabel[this.numGoggas] = paramString;
/*      */       
/*  409 */       this.numGoggas += 1;
/*      */       
/*  411 */       repaint();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void drawGoggaTrail(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, int paramInt5)
/*      */     {
/*  420 */       int n = 5 + this.textWidth + 10;
/*  421 */       int i1 = 5 + this.textHeight + 10;
/*  422 */       int i = n + Math.min(paramInt1, paramInt3) * 25;
/*  423 */       int j = i1 + Math.min(paramInt2, paramInt4) * 25;
/*  424 */       int k = n + Math.max(paramInt1, paramInt3) * 25;
/*  425 */       int m = i1 + Math.max(paramInt2, paramInt4) * 25;
/*      */       
/*  427 */       waitForOffscreen();
/*      */       
/*  429 */       Graphics localGraphics = this.offscreen.getGraphics();
/*  430 */       localGraphics.setColor(paramColor);
/*      */       int i2;
/*      */       int i3;
/*  433 */       int i4; if (i != k)
/*      */       {
/*  435 */         i2 = j - paramInt5 / 2;
/*  436 */         i3 = i2 + paramInt5;
/*      */         
/*  438 */         for (i4 = i2; i4 < i3; i4++)
/*      */         {
/*  440 */           localGraphics.drawLine(i, i4, k, i4);
/*      */         }
/*  442 */         localGraphics.fillOval(i - paramInt5 / 2, i2, paramInt5, paramInt5);
/*  443 */         localGraphics.fillOval(k - paramInt5 / 2, i2, paramInt5, paramInt5);
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  453 */         i2 = i - paramInt5 / 2;
/*  454 */         i3 = i2 + paramInt5;
/*      */         
/*  456 */         for (i4 = i2; i4 < i3; i4++)
/*      */         {
/*  458 */           localGraphics.drawLine(i4, j, i4, m);
/*      */         }
/*  460 */         localGraphics.fillOval(i2, j - paramInt5 / 2, paramInt5, paramInt5);
/*  461 */         localGraphics.fillOval(i2, m - paramInt5 / 2, paramInt5, paramInt5);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void saveToFile(String paramString)
/*      */     {
/*  475 */       java.awt.Image localImage = createImage(this.canvasWidth, this.canvasHeight);
/*  476 */       update(localImage.getGraphics());
/*      */       
/*      */ 
/*  479 */       long l = 0L; GoggaGrid 
/*      */       
/*      */ 
/*  482 */         tmp32_29 = GoggaGrid.this;
/*      */       
/*      */ 
/*  482 */       if (tmp32_29 == null) throw null; this.status = new GoggaGrid.Status(tmp32_29, "Calculating Size", "Converting to BMP");
/*      */       
/*      */ 
/*  485 */       int[] arrayOfInt1 = new int[this.canvasHeight * this.canvasWidth];
/*  486 */       byte[] arrayOfByte = new byte[this.canvasHeight * this.canvasWidth];
/*  487 */       int[] arrayOfInt2 = new int['Ā'];
/*  488 */       int i = 0;
/*      */       
/*      */ 
/*      */ 
/*  492 */       for (int j = 0; j < this.canvasHeight; j += 75)
/*      */       {
/*      */ 
/*  495 */         if (System.currentTimeMillis() - l > 1000L)
/*      */         {
/*  497 */           l = System.currentTimeMillis();
/*  498 */           this.status.setMessage("Grabbing pixels: " + j * 100 / this.canvasHeight + "% Done");
/*      */         }
/*      */         
/*      */ 
/*  502 */         java.awt.image.PixelGrabber localPixelGrabber = new java.awt.image.PixelGrabber(localImage, 0, j, this.canvasWidth, Math.min(75, this.canvasWidth - j), arrayOfInt1, j * this.canvasWidth, this.canvasWidth);
/*      */         
/*      */ 
/*      */ 
/*      */         try
/*      */         {
/*  508 */           if (!localPixelGrabber.grabPixels())
/*      */           {
/*  510 */             this.status.dispose(); GoggaGrid 
/*  511 */               tmp210_207 = GoggaGrid.this;
/*  511 */             if (tmp210_207 == null) throw null; new GoggaGrid.Message(tmp210_207, "Unable to get picture image");
/*  512 */             return;
/*      */           }
/*      */         }
/*      */         catch (InterruptedException localInterruptedException)
/*      */         {
/*  517 */           this.status.dispose(); GoggaGrid 
/*  518 */             tmp241_238 = GoggaGrid.this;
/*  518 */           if (tmp241_238 == null) throw null; new GoggaGrid.Message(tmp241_238, "Unable to get picture image");
/*  519 */           return;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  524 */       for (int k = 0; k < this.canvasHeight; k++)
/*      */       {
/*      */ 
/*  527 */         if (System.currentTimeMillis() - l > 1000L)
/*      */         {
/*  529 */           l = System.currentTimeMillis();
/*  530 */           this.status.setMessage("Making Colormap: " + k * 100 / this.canvasHeight + "% Done");
/*      */         }
/*      */         
/*      */ 
/*  534 */         for (int m = 0; m < this.canvasWidth; m++)
/*      */         {
/*  536 */           int n = arrayOfInt1[(k * this.canvasWidth + m)] & 0xFFFFFF;
/*  537 */           for (j = 0; j < i; j++)
/*  538 */             if (n == arrayOfInt2[j])
/*      */               break;
/*  540 */           if (j > 255)
/*      */           {
/*  542 */             arrayOfByte = null;
/*      */             
/*  544 */             write24BitBMP(arrayOfInt1, this.canvasWidth, this.canvasHeight, paramString);
/*  545 */             if (this.status != null)
/*      */             {
/*  547 */               this.status.dispose();
/*      */             }
/*  549 */             return;
/*      */           }
/*  551 */           arrayOfByte[(k * this.canvasWidth + m)] = ((byte)j);
/*  552 */           if (j == i)
/*      */           {
/*  554 */             arrayOfInt2[(i++)] = n;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  560 */       arrayOfInt1 = null;
/*  561 */       if (i <= 2)
/*      */       {
/*  563 */         write1BitBMP(arrayOfByte, arrayOfInt2, this.canvasWidth, this.canvasHeight, paramString);
/*      */       }
/*  565 */       else if (i <= 16)
/*      */       {
/*  567 */         write4BitBMP(arrayOfByte, arrayOfInt2, this.canvasWidth, this.canvasHeight, paramString);
/*      */       }
/*      */       else
/*      */       {
/*  571 */         write8BitBMP(arrayOfByte, arrayOfInt2, this.canvasWidth, this.canvasHeight, paramString);
/*      */       }
/*      */       
/*  574 */       if (this.status != null)
/*      */       {
/*  576 */         this.status.dispose();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */     public int print(Graphics paramGraphics, java.awt.print.PageFormat paramPageFormat, int paramInt)
/*      */     {
/*  583 */       if (paramInt > 0)
/*      */       {
/*  585 */         return 1;
/*      */       }
/*      */       
/*  588 */       int i = (int)paramPageFormat.getImageableX();
/*  589 */       int j = (int)paramPageFormat.getImageableY();
/*  590 */       int k = i + (int)paramPageFormat.getImageableWidth();
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  597 */       java.text.SimpleDateFormat localSimpleDateFormat = new java.text.SimpleDateFormat("d MMM yyyy HH:mm:ss");
/*  598 */       localSimpleDateFormat.setTimeZone(java.util.TimeZone.getDefault());
/*  599 */       String str1 = localSimpleDateFormat.format(new java.util.Date());
/*  600 */       String str2 = System.getProperty("user.name");
/*      */       
/*  602 */       Font localFont = new Font("SansSerif", 1, 12);
/*  603 */       FontMetrics localFontMetrics = getFontMetrics(localFont);
/*  604 */       paramGraphics.setColor(Color.black);
/*  605 */       paramGraphics.setFont(localFont);
/*  606 */       if (str2.length() != 0)
/*      */       {
/*  608 */         paramGraphics.drawString(str2, i + 2, j + localFontMetrics.getHeight() + 2);
/*      */       }
/*  610 */       paramGraphics.drawString(str1, k - 2 - localFontMetrics.stringWidth(str1), j + localFontMetrics.getHeight() + 2);
/*      */       
/*      */ 
/*      */ 
/*  614 */       int m = ((int)paramPageFormat.getImageableWidth() - this.canvasWidth) / 2 + i;
/*  615 */       int n = 3 * localFontMetrics.getHeight() + j;
/*  616 */       paramGraphics.translate(m, n);
/*  617 */       update(paramGraphics);
/*      */       
/*  619 */       return 0;
/*      */     }
/*      */     
/*      */ 
/*      */     private synchronized void initializeOffscreen()
/*      */     {
/*  625 */       this.offscreen = createImage(this.canvasWidth, this.canvasHeight);
/*      */       
/*  627 */       int i = 5 + this.textWidth + 10;
/*  628 */       int j = i + (this.gr.xSize - 1) * 25;
/*  629 */       int k = 5 + this.textHeight + 10;
/*  630 */       int m = k + (this.gr.ySize - 1) * 25;
/*      */       
/*      */ 
/*  633 */       Graphics localGraphics = this.offscreen.getGraphics();
/*      */       
/*  635 */       localGraphics.setFont(this.gridLabelFont);
/*  636 */       localGraphics.setColor(Color.black);
/*      */       
/*      */ 
/*  639 */       int i1 = k;
/*  640 */       for (int i2 = 0; i2 < this.gr.ySize; i2++)
/*      */       {
/*  642 */         n = 5;
/*  643 */         if (i2 < 10)
/*  644 */           n += this.textWidth / 2;
/*  645 */         localGraphics.drawString("" + i2, n, i1 + this.textWidth / 2);
/*  646 */         localGraphics.drawLine(i, i1, j, i1);
/*  647 */         i1 += 25;
/*      */       }
/*      */       
/*      */ 
/*  651 */       int n = i;
/*  652 */       i1 = 5 + this.textHeight;
/*  653 */       for (i2 = 0; i2 < this.gr.xSize; i2++)
/*      */       {
/*  655 */         int i3 = n - this.textWidth / 2;
/*  656 */         if (i2 < 10)
/*  657 */           i3 += this.textWidth / 4;
/*  658 */         localGraphics.drawString("" + i2, i3, i1);
/*  659 */         localGraphics.drawLine(n, k, n, m);
/*  660 */         n += 25;
/*      */       }
/*      */       
/*      */ 
/*  664 */       notifyAll();
/*      */     }
/*      */     
/*      */ 
/*      */     private synchronized void waitForOffscreen()
/*      */     {
/*  670 */       if (this.offscreen == null)
/*      */       {
/*      */         try
/*      */         {
/*  674 */           wait();
/*      */         }
/*      */         catch (InterruptedException localInterruptedException) {}
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void write1BitBMP(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, String paramString)
/*      */     {
/*  690 */       long l = 0L;
/*      */       
/*  692 */       this.status.setMessage("Writing 1 bit BMP");
/*      */       
/*      */ 
/*  695 */       int i = (4 - paramInt1 / 8 % 4) % 4;
/*  696 */       int j = (paramInt1 / 8 + i) * paramInt2;
/*  697 */       byte[] arrayOfByte = new byte[j];
/*      */       
/*  699 */       int k = 0;
/*  700 */       for (int m = 0; m < paramInt2; m++)
/*      */       {
/*      */ 
/*  703 */         if (System.currentTimeMillis() - l > 1000L)
/*      */         {
/*  705 */           l = System.currentTimeMillis();
/*  706 */           this.status.setMessage("Converting to BMP: " + m * 100 / paramInt2 + "% Done");
/*      */         }
/*      */         
/*      */ 
/*  710 */         for (int n = 0; n < paramInt1; n++)
/*      */         {
/*  712 */           int i1 = paramArrayOfByte[((paramInt2 - 1 - m) * paramInt1 + n)]; int 
/*  713 */             tmp135_133 = k; byte[] tmp135_131 = arrayOfByte;tmp135_131[tmp135_133] = ((byte)(tmp135_131[tmp135_133] | tmp135_133 << 7 - n % 8));
/*  714 */           if ((n % 8 == 7) || (n == paramInt1 - 1))
/*  715 */             k++;
/*      */         }
/*  717 */         for (n = 0; n < i; n++)
/*      */         {
/*  719 */           arrayOfByte[(k++)] = 0;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  725 */       writeBMPFile(paramString, j, 2, paramInt1, paramInt2, 1, 0, paramArrayOfInt, arrayOfByte);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void write24BitBMP(int[] paramArrayOfInt, int paramInt1, int paramInt2, String paramString)
/*      */     {
/*  736 */       long l = 0L;
/*      */       
/*  738 */       this.status.setMessage("Writing 24 bit BMP");
/*      */       
/*      */ 
/*  741 */       int i = (4 - paramInt1 * 3 % 4) % 4;
/*  742 */       int j = (paramInt1 * 3 + i) * paramInt2;
/*  743 */       byte[] arrayOfByte = new byte[j];
/*      */       
/*  745 */       int k = 0;
/*  746 */       for (int m = 0; m < paramInt2; m++)
/*      */       {
/*      */ 
/*  749 */         if (System.currentTimeMillis() - l > 1000L)
/*      */         {
/*  751 */           l = System.currentTimeMillis();
/*  752 */           this.status.setMessage("Converting to BMP: " + m * 100 / paramInt2 + "% Done");
/*      */         }
/*      */         
/*      */ 
/*  756 */         for (int n = 0; n < paramInt1; n++)
/*      */         {
/*  758 */           int i1 = paramArrayOfInt[((paramInt2 - 1 - m) * paramInt1 + n)];
/*  759 */           arrayOfByte[(k++)] = ((byte)(i1 & 0xFF));
/*  760 */           arrayOfByte[(k++)] = ((byte)(i1 >> 8 & 0xFF));
/*  761 */           arrayOfByte[(k++)] = ((byte)(i1 >> 16 & 0xFF));
/*      */         }
/*  763 */         for (n = 0; n < i; n++)
/*      */         {
/*  765 */           arrayOfByte[(k++)] = 0;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  771 */       writeBMPFile(paramString, j, 0, paramInt1, paramInt2, 24, 0, null, arrayOfByte);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void write4BitBMP(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, String paramString)
/*      */     {
/*  782 */       int[] arrayOfInt = { 4, 0 };
/*  783 */       long l = 0L;
/*      */       
/*  785 */       this.status.setMessage("Writing 4 bit BMP");
/*      */       
/*      */ 
/*  788 */       int i = (4 - paramInt1 / 2 % 4) % 4;
/*  789 */       int j = (paramInt1 / 2 + i) * paramInt2;
/*  790 */       byte[] arrayOfByte1 = new byte[j];
/*      */       
/*  792 */       int k = 0;
/*  793 */       for (int m = 0; m < paramInt2; m++)
/*      */       {
/*      */ 
/*  796 */         if (System.currentTimeMillis() - l > 1000L)
/*      */         {
/*  798 */           l = System.currentTimeMillis();
/*  799 */           this.status.setMessage("Converting to BMP: " + m * 100 / paramInt2 + "% Done");
/*      */         }
/*      */         
/*      */ 
/*  803 */         for (n = 0; n < paramInt1; n++)
/*      */         {
/*  805 */           i1 = paramArrayOfByte[((paramInt2 - 1 - m) * paramInt1 + n)]; int 
/*  806 */             tmp146_144 = k; byte[] tmp146_142 = arrayOfByte1;tmp146_142[tmp146_144] = ((byte)(tmp146_142[tmp146_144] | i1 << arrayOfInt[(n % 2)]));
/*  807 */           if ((n % 2 == 1) || (n == paramInt1 - 1))
/*  808 */             k++;
/*      */         }
/*  810 */         for (n = 0; n < i; n++)
/*      */         {
/*  812 */           arrayOfByte1[(k++)] = 0;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  818 */       this.status.setMessage("Compressing the bitmap");
/*  819 */       byte[] arrayOfByte2 = new byte[j];
/*  820 */       int n = paramInt1 / 2 + i;
/*  821 */       int i1 = 0;
/*  822 */       for (int i2 = 0; i2 < paramInt2; i2++)
/*      */       {
/*  824 */         int i3 = i2;
/*      */         
/*      */ 
/*  827 */         int i4 = 0;
/*  828 */         int i5; for (; i4 < (paramInt1 + 1) / 2; 
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  894 */             i4 != i5)
/*      */         {
/*  830 */           i5 = i4;
/*      */           
/*      */ 
/*  833 */           int i6 = 0;
/*  834 */           while ((i6 == 0) && (i4 < paramInt1 - 4))
/*      */           {
/*  836 */             i7 = i2 * n + i4;
/*  837 */             if ((arrayOfByte1[i7] == arrayOfByte1[(i7 + 1)]) && (arrayOfByte1[(i7 + 1)] == arrayOfByte1[(i7 + 2)]))
/*      */             {
/*      */ 
/*  840 */               i6 = 1;
/*  841 */               break;
/*      */             }
/*  843 */             i4++;
/*      */           }
/*      */           
/*      */ 
/*  847 */           if (i6 == 0) {
/*  848 */             i4 = (paramInt1 + 1) / 2;
/*      */           }
/*  850 */           while (i4 - i5 > 2)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  855 */             if (i1 + 300 > j)
/*      */             {
/*      */ 
/*  858 */               writeBMPFile(paramString, j, 16, paramInt1, paramInt2, 4, 0, paramArrayOfInt, arrayOfByte1);
/*      */               
/*  860 */               return;
/*      */             }
/*      */             
/*  863 */             i7 = Math.min(i4 - i5, 127);
/*  864 */             arrayOfByte2[(i1++)] = 0;
/*  865 */             arrayOfByte2[(i1++)] = ((byte)(i7 * 2));
/*  866 */             i8 = i2 * n + i5;
/*  867 */             for (i9 = 0; i9 < i7; i9++)
/*      */             {
/*  869 */               arrayOfByte2[(i1++)] = arrayOfByte1[(i8 + i9)];
/*      */             }
/*  871 */             if (i7 % 2 == 1)
/*  872 */               arrayOfByte2[(i1++)] = 0;
/*  873 */             i5 += i7;
/*      */           }
/*  875 */           i4 = i5;
/*      */           
/*  877 */           if (i4 == paramInt1) {
/*      */             break;
/*      */           }
/*      */           
/*  881 */           int i7 = arrayOfByte1[(i2 * n + i4)];
/*  882 */           int i8 = 1;
/*  883 */           i4++;
/*  884 */           while ((i8 != 0) && (i4 < (paramInt1 + 1) / 2))
/*      */           {
/*  886 */             if (arrayOfByte1[(i2 * n + i4)] != i7)
/*      */             {
/*  888 */               i8 = 0;
/*  889 */               break;
/*      */             }
/*  891 */             i4++;
/*      */           }
/*      */           
/*  894 */           continue;
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*  899 */           if (i1 + 300 > j)
/*      */           {
/*      */ 
/*  902 */             writeBMPFile(paramString, j, 16, paramInt1, paramInt2, 4, 0, paramArrayOfInt, arrayOfByte1);
/*      */             
/*  904 */             return;
/*      */           }
/*      */           
/*  907 */           int i9 = Math.min(i4 - i5, 127);
/*  908 */           arrayOfByte2[(i1++)] = ((byte)(i9 * 2));
/*  909 */           arrayOfByte2[(i1++)] = i7;
/*  910 */           i5 += i9;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  915 */         arrayOfByte2[(i1++)] = 0;
/*  916 */         arrayOfByte2[(i1++)] = 0;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  921 */       arrayOfByte2[(i1++)] = 0;
/*  922 */       arrayOfByte2[(i1++)] = 1;
/*      */       
/*  924 */       writeBMPFile(paramString, i1, 16, paramInt1, paramInt2, 4, 2, paramArrayOfInt, arrayOfByte2);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void write8BitBMP(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, String paramString)
/*      */     {
/*  935 */       long l = 0L;
/*      */       
/*  937 */       this.status.setMessage("Writing 8 bit BMP");
/*      */       
/*      */ 
/*  940 */       int i = (4 - paramInt1 % 4) % 4;
/*  941 */       int j = (paramInt1 + i) * paramInt2;
/*  942 */       byte[] arrayOfByte1 = new byte[j];
/*      */       
/*  944 */       int k = 0;
/*  945 */       for (int m = 0; m < paramInt2; m++)
/*      */       {
/*      */ 
/*  948 */         if (System.currentTimeMillis() - l > 1000L)
/*      */         {
/*  950 */           l = System.currentTimeMillis();
/*  951 */           this.status.setMessage("Converting to BMP: " + m * 100 / paramInt2 + "% Done");
/*      */         }
/*      */         
/*      */ 
/*  955 */         for (n = 0; n < paramInt1; n++)
/*      */         {
/*  957 */           int tmp116_113 = (k++); byte[] tmp116_109 = arrayOfByte1;tmp116_109[tmp116_113] = ((byte)(tmp116_109[tmp116_113] | paramArrayOfByte[((paramInt2 - 1 - m) * paramInt1 + n)]));
/*      */         }
/*  959 */         for (n = 0; n < i; n++)
/*      */         {
/*  961 */           arrayOfByte1[(k++)] = 0;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  967 */       this.status.setMessage("Compressing the bitmap");
/*  968 */       byte[] arrayOfByte2 = new byte[j];
/*  969 */       int n = paramInt1 + i;
/*  970 */       int i1 = 0;
/*  971 */       for (int i2 = 0; i2 < paramInt2; i2++)
/*      */       {
/*  973 */         int i3 = i2;
/*      */         
/*      */ 
/*  976 */         int i4 = 0;
/*  977 */         int i5; for (; i4 < paramInt1; 
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1043 */             i4 != i5)
/*      */         {
/*  979 */           i5 = i4;
/*      */           
/*      */ 
/*  982 */           int i6 = 0;
/*  983 */           while ((i6 == 0) && (i4 < paramInt1 - 4))
/*      */           {
/*  985 */             i7 = i2 * n + i4;
/*  986 */             if ((arrayOfByte1[i7] == arrayOfByte1[(i7 + 1)]) && (arrayOfByte1[(i7 + 1)] == arrayOfByte1[(i7 + 2)]))
/*      */             {
/*      */ 
/*  989 */               i6 = 1;
/*  990 */               break;
/*      */             }
/*  992 */             i4++;
/*      */           }
/*      */           
/*      */ 
/*  996 */           if (i6 == 0) {
/*  997 */             i4 = paramInt1;
/*      */           }
/*  999 */           while (i4 - i5 > 2)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1004 */             if (i1 + 300 > j)
/*      */             {
/*      */ 
/* 1007 */               writeBMPFile(paramString, j, 256, paramInt1, paramInt2, 8, 0, paramArrayOfInt, arrayOfByte1);
/*      */               
/* 1009 */               return;
/*      */             }
/*      */             
/* 1012 */             i7 = Math.min(i4 - i5, 255);
/* 1013 */             arrayOfByte2[(i1++)] = 0;
/* 1014 */             arrayOfByte2[(i1++)] = ((byte)i7);
/* 1015 */             i8 = i2 * n + i5;
/* 1016 */             for (i9 = 0; i9 < i7; i9++)
/*      */             {
/* 1018 */               arrayOfByte2[(i1++)] = arrayOfByte1[(i8 + i9)];
/*      */             }
/* 1020 */             if (i7 % 2 == 1)
/* 1021 */               arrayOfByte2[(i1++)] = 0;
/* 1022 */             i5 += i7;
/*      */           }
/* 1024 */           i4 = i5;
/*      */           
/* 1026 */           if (i4 == paramInt1) {
/*      */             break;
/*      */           }
/*      */           
/* 1030 */           int i7 = arrayOfByte1[(i2 * n + i4)];
/* 1031 */           int i8 = 1;
/* 1032 */           i4++;
/* 1033 */           while ((i8 != 0) && (i4 < paramInt1))
/*      */           {
/* 1035 */             if (arrayOfByte1[(i2 * n + i4)] != i7)
/*      */             {
/* 1037 */               i8 = 0;
/* 1038 */               break;
/*      */             }
/* 1040 */             i4++;
/*      */           }
/*      */           
/* 1043 */           continue;
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 1048 */           if (i1 + 300 > j)
/*      */           {
/*      */ 
/* 1051 */             writeBMPFile(paramString, j, 256, paramInt1, paramInt2, 8, 0, paramArrayOfInt, arrayOfByte1);
/*      */             
/* 1053 */             return;
/*      */           }
/*      */           
/* 1056 */           int i9 = Math.min(i4 - i5, 255);
/* 1057 */           arrayOfByte2[(i1++)] = ((byte)i9);
/* 1058 */           arrayOfByte2[(i1++)] = i7;
/* 1059 */           i5 += i9;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/* 1064 */         arrayOfByte2[(i1++)] = 0;
/* 1065 */         arrayOfByte2[(i1++)] = 0;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1070 */       arrayOfByte2[(i1++)] = 0;
/* 1071 */       arrayOfByte2[(i1++)] = 1;
/*      */       
/* 1073 */       writeBMPFile(paramString, i1, 256, paramInt1, paramInt2, 8, 1, paramArrayOfInt, arrayOfByte2);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void writeBMPFile(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt, byte[] paramArrayOfByte)
/*      */     {
/* 1085 */       this.status.setMessage("Writing image");
/*      */       
/*      */       try
/*      */       {
/* 1089 */         this.out = new DataOutputStream(new java.io.FileOutputStream(paramString));
/*      */         
/*      */ 
/* 1092 */         writeShort(19778);
/* 1093 */         writeInt(paramInt1 + 54 + paramInt2 * 4);
/* 1094 */         writeShort(0);
/* 1095 */         writeShort(0);
/* 1096 */         writeInt(54 + paramInt2 * 4);
/*      */         
/* 1098 */         writeInt(40);
/* 1099 */         writeInt(paramInt3);
/* 1100 */         writeInt(paramInt4);
/* 1101 */         writeShort(1);
/* 1102 */         writeShort(paramInt5);
/* 1103 */         writeInt(paramInt6);
/* 1104 */         writeInt(paramInt1);
/* 1105 */         writeInt(2835);
/* 1106 */         writeInt(2835);
/* 1107 */         writeInt(paramInt2);
/* 1108 */         writeInt(paramInt2);
/*      */         
/*      */ 
/* 1111 */         for (int i = 0; i < paramInt2; i++)
/*      */         {
/* 1113 */           int j = paramArrayOfInt[i];
/*      */           
/* 1115 */           this.out.writeByte(j & 0xFF);
/* 1116 */           this.out.writeByte(j >> 8 & 0xFF);
/* 1117 */           this.out.writeByte(j >> 16 & 0xFF);
/* 1118 */           this.out.writeByte(0);
/*      */         }
/*      */         
/*      */ 
/* 1122 */         this.out.write(paramArrayOfByte, 0, paramInt1);
/*      */         
/* 1124 */         this.out.close();
/*      */         
/* 1126 */         this.out = null;
/*      */ 
/*      */ 
/*      */       }
/*      */       catch (IOException localIOException1) {}finally
/*      */       {
/*      */ 
/* 1133 */         if (this.out != null)
/*      */         {
/*      */           try
/*      */           {
/* 1137 */             this.out.close();
/* 1138 */             this.out = null;
/*      */           }
/*      */           catch (IOException localIOException2) {}
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void writeInt(int paramInt)
/*      */     {
/*      */       try
/*      */       {
/* 1155 */         this.out.writeByte(paramInt & 0xFF);
/* 1156 */         this.out.writeByte(paramInt >> 8 & 0xFF);
/* 1157 */         this.out.writeByte(paramInt >> 16 & 0xFF);
/* 1158 */         this.out.writeByte(paramInt >> 24 & 0xFF);
/*      */       }
/*      */       catch (IOException localIOException) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void writeShort(int paramInt)
/*      */     {
/*      */       try
/*      */       {
/* 1174 */         this.out.writeByte(paramInt & 0xFF);
/* 1175 */         this.out.writeByte(paramInt >> 8 & 0xFF);
/*      */       }
/*      */       catch (IOException localIOException) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   class WindowCloser
/*      */     extends java.awt.event.WindowAdapter
/*      */   {
/*      */     public void windowClosing(java.awt.event.WindowEvent paramWindowEvent)
/*      */     {
/* 1189 */       paramWindowEvent.getWindow().dispose();
/* 1190 */       System.exit(0);
/*      */     }
/*      */     
/*      */     WindowCloser() {}
/*      */   }
/*      */   
/*      */   class Status
/*      */   {
/*      */     public void setMessage(String paramString) {}
/*      */     
/*      */     public void dispose() {}
/*      */     
/*      */     public Status(String paramString1, String paramString2) {}
/*      */   }
/*      */   
/*      */   class Message
/*      */   {
/*      */     public Message(String paramString) {}
/*      */   }
/*      */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\GoggaGrid.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */