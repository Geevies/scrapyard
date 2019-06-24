/*     */ package gogga;
/*     */ 
/*     */ import java.awt.geom.Point2D.Double;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TrigGraph
/*     */   extends Graphable
/*     */ {
/*     */   public static final byte SIN = 0;
/*     */   public static final byte ASIN = 1;
/*     */   public static final byte COS = 2;
/*     */   public static final byte ACOS = 3;
/*     */   public static final byte TAN = 4;
/*     */   public static final byte ATAN = 5;
/*     */   private byte type;
/*     */   private double amplitude;
/*     */   private double period;
/*     */   private double phase;
/*     */   
/*     */   private TrigGraph()
/*     */   {
/*  28 */     super((byte)3);this.amplitude = 1.0D;this.period = 1.0D;this.phase = 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrigGraph(byte paramByte)
/*     */   {
/*  36 */     super((byte)3);this.amplitude = 1.0D;this.period = 1.0D;this.phase = 0.0D;
/*  37 */     this.type = paramByte;
/*  38 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrigGraph(byte paramByte, double paramDouble1, double paramDouble2, double paramDouble3)
/*     */   {
/*  49 */     this(paramByte);
/*  50 */     this.amplitude = paramDouble1;
/*  51 */     this.period = paramDouble2;
/*  52 */     this.phase = paramDouble3;
/*  53 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setAmplitude(double paramDouble)
/*     */   {
/*  61 */     this.amplitude = paramDouble;
/*  62 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setPeriod(double paramDouble)
/*     */   {
/*  70 */     this.period = paramDouble;
/*  71 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setPhase(double paramDouble)
/*     */   {
/*  79 */     this.phase = paramDouble;
/*  80 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setTrigParams(double paramDouble1, double paramDouble2, double paramDouble3)
/*     */   {
/*  90 */     this.amplitude = paramDouble1;
/*  91 */     this.period = paramDouble2;
/*  92 */     this.phase = paramDouble3;
/*  93 */     Graphable.grapher.pushChanges();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void evaluateXY(Point2D.Double paramDouble)
/*     */   {
/* 105 */     switch (this.type) {
/* 106 */     case 0:  paramDouble.y = (this.amplitude * Math.sin(this.period * paramDouble.x + this.phase));
/* 107 */       return;
/*     */     case 1: 
/* 109 */       if ((this.amplitude == 0.0D) || (this.period == 0.0D)) {
/* 110 */         paramDouble.y = NaN.0D;
/* 111 */         return;
/*     */       }
/*     */       
/* 114 */       paramDouble.y = ((Math.asin(paramDouble.x / this.amplitude) - this.phase) / this.period);
/* 115 */       return;
/*     */     
/*     */     case 2: 
/* 118 */       paramDouble.y = (this.amplitude * Math.cos(this.period * paramDouble.x + this.phase));
/* 119 */       return;
/*     */     case 3: 
/* 121 */       if ((this.amplitude == 0.0D) || (this.period == 0.0D)) {
/* 122 */         paramDouble.y = NaN.0D;
/* 123 */         return;
/*     */       }
/*     */       
/* 126 */       paramDouble.y = ((Math.acos(paramDouble.x / this.amplitude) - this.phase) / this.period);
/* 127 */       return;
/*     */     
/*     */     case 4: 
/* 130 */       paramDouble.y = (this.amplitude * Math.tan(this.period * paramDouble.x + this.phase));
/* 131 */       return;
/*     */     case 5: 
/* 133 */       if ((this.amplitude == 0.0D) || (this.period == 0.0D)) {
/* 134 */         paramDouble.y = NaN.0D;
/* 135 */         return;
/*     */       }
/*     */       
/* 138 */       paramDouble.y = ((Math.atan(paramDouble.x / this.amplitude) - this.phase) / this.period);
/* 139 */       return;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 144 */     paramDouble.y = 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\TrigGraph.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */