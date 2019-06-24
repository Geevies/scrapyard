/*     */ package gogga;
/*     */ 
/*     */ import java.awt.Color;
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
/*     */ public class Gogga
/*     */ {
/*     */   public static final int UP = 1;
/*     */   public static final int DOWN = 2;
/*     */   public static final int LEFT = 3;
/*     */   public static final int RIGHT = 4;
/*     */   static final int DEFAULT_X = -99;
/*     */   static final int DEFAULT_DIR = 1;
/*     */   static final int DEFAULT_TRAIL_WIDTH = 5;
/*     */   static final Color DEFAULT_COLOR = Color.red;
/*     */   static boolean gridInitialized = false;
/*     */   static int xSize = 0;
/*     */   static int ySize = 0;
/*     */   static GoggaGrid gr;
/*     */   int xPos;
/*     */   int yPos;
/*     */   int direction;
/*     */   Color color;
/*     */   int trailWidth;
/*     */   boolean trailVisible;
/*     */   String label;
/*     */   
/*     */   public Gogga(int paramInt1, int paramInt2, int paramInt3, Color paramColor)
/*     */   {
/*  98 */     initializeGridIfNecessary();
/*     */     
/* 100 */     if (paramInt1 == -99)
/*     */     {
/* 102 */       this.xPos = (gr.getXSize() / 2);
/* 103 */       this.yPos = (gr.getYSize() / 2);
/*     */     }
/*     */     else
/*     */     {
/* 107 */       this.xPos = paramInt1;
/* 108 */       this.yPos = paramInt2;
/*     */     }
/* 110 */     this.direction = paramInt3;
/* 111 */     this.color = paramColor;
/* 112 */     this.trailWidth = 5;
/* 113 */     this.trailVisible = true;
/* 114 */     this.label = "";
/*     */     
/* 116 */     gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Gogga()
/*     */   {
/* 125 */     this(-99, -99, 1, DEFAULT_COLOR);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Gogga(int paramInt1, int paramInt2)
/*     */   {
/* 135 */     this(paramInt1, paramInt2, 1, DEFAULT_COLOR);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Gogga(Color paramColor)
/*     */   {
/* 145 */     this(-99, -99, 1, paramColor);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Gogga(int paramInt1, int paramInt2, Color paramColor)
/*     */   {
/* 155 */     this(paramInt1, paramInt2, 1, paramColor);
/*     */   }
/*     */   
/*     */ 
/*     */   private void initializeGridIfNecessary()
/*     */   {
/* 161 */     if (!gridInitialized)
/*     */     {
/* 163 */       if (xSize != 0)
/*     */       {
/* 165 */         gr = new GoggaGrid(xSize, ySize);
/*     */       }
/*     */       else
/*     */       {
/* 169 */         gr = new GoggaGrid();
/*     */       }
/* 171 */       gridInitialized = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void move()
/*     */   {
/* 181 */     switch (this.direction)
/*     */     {
/*     */     case 1: 
/* 184 */       if (this.yPos == 0)
/*     */       {
/* 186 */         System.out.println("The Gogga hit the top of the grid!");
/*     */         
/* 188 */         System.out.println("Command ignored");
/*     */       }
/*     */       else
/*     */       {
/* 192 */         if (this.trailVisible)
/*     */         {
/* 194 */           gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos, this.yPos - 1, this.color, this.trailWidth);
/*     */         }
/*     */         
/* 197 */         setPosition(this.xPos, this.yPos - 1);
/*     */       }
/* 199 */       break;
/*     */     case 2: 
/* 201 */       if (this.yPos == gr.getYSize() - 1)
/*     */       {
/* 203 */         System.out.println("The Gogga hit the bottom of the grid!");
/*     */         
/* 205 */         System.out.println("Command ignored");
/*     */       }
/*     */       else
/*     */       {
/* 209 */         if (this.trailVisible)
/*     */         {
/* 211 */           gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos, this.yPos + 1, this.color, this.trailWidth);
/*     */         }
/*     */         
/* 214 */         setPosition(this.xPos, this.yPos + 1);
/*     */       }
/* 216 */       break;
/*     */     case 3: 
/* 218 */       if (this.xPos == 0)
/*     */       {
/* 220 */         System.out.println("The Gogga hit the left side of the grid!");
/*     */         
/* 222 */         System.out.println("Command ignored");
/*     */       }
/*     */       else
/*     */       {
/* 226 */         if (this.trailVisible)
/*     */         {
/* 228 */           gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos - 1, this.yPos, this.color, this.trailWidth);
/*     */         }
/*     */         
/* 231 */         setPosition(this.xPos - 1, this.yPos);
/*     */       }
/* 233 */       break;
/*     */     case 4: 
/* 235 */       if (this.xPos == gr.getXSize() - 1)
/*     */       {
/* 237 */         System.out.println("The Gogga hit the right side of the grid!");
/*     */         
/* 239 */         System.out.println("Command ignored");
/*     */       }
/*     */       else
/*     */       {
/* 243 */         if (this.trailVisible)
/*     */         {
/* 245 */           gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos + 1, this.yPos, this.color, this.trailWidth);
/*     */         }
/*     */         
/* 248 */         setPosition(this.xPos + 1, this.yPos);
/*     */       }
/* 250 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void turnRight()
/*     */   {
/* 260 */     switch (this.direction)
/*     */     {
/*     */     case 1: 
/* 263 */       setDirection(4);
/* 264 */       break;
/*     */     case 2: 
/* 266 */       setDirection(3);
/* 267 */       break;
/*     */     case 3: 
/* 269 */       setDirection(1);
/* 270 */       break;
/*     */     case 4: 
/* 272 */       setDirection(2);
/* 273 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void turnLeft()
/*     */   {
/* 283 */     switch (this.direction)
/*     */     {
/*     */     case 1: 
/* 286 */       setDirection(3);
/* 287 */       break;
/*     */     case 2: 
/* 289 */       setDirection(4);
/* 290 */       break;
/*     */     case 3: 
/* 292 */       setDirection(2);
/* 293 */       break;
/*     */     case 4: 
/* 295 */       setDirection(1);
/* 296 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getXPos()
/*     */   {
/* 307 */     return this.xPos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getYPos()
/*     */   {
/* 317 */     return this.yPos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getDirection()
/*     */   {
/* 328 */     return this.direction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPosition(int paramInt1, int paramInt2)
/*     */   {
/* 340 */     gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/* 341 */     this.xPos = paramInt1;
/* 342 */     this.yPos = paramInt2;
/* 343 */     gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDirection(int paramInt)
/*     */   {
/* 354 */     gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/* 355 */     this.direction = paramInt;
/* 356 */     gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setColor(Color paramColor)
/*     */   {
/* 367 */     gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/* 368 */     this.color = paramColor;
/* 369 */     gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTrailWidth(int paramInt)
/*     */   {
/* 380 */     this.trailWidth = paramInt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLabel(String paramString)
/*     */   {
/* 390 */     gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/* 391 */     this.label = paramString;
/* 392 */     gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void trailOn()
/*     */   {
/* 401 */     this.trailVisible = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void trailOff()
/*     */   {
/* 410 */     this.trailVisible = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setGridSize(int paramInt1, int paramInt2)
/*     */   {
/* 421 */     if (gridInitialized)
/*     */     {
/* 423 */       System.out.println("The Gogga.setGridSize method must be called before the first Gogga is created");
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 428 */       xSize = paramInt1;
/* 429 */       ySize = paramInt2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\Gogga.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */