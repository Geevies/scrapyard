/*     */ package gogga;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Enumeration;
/*     */ import java.util.EventObject;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.BevelBorder;
/*     */ 
/*     */ public class GraphFrame
/*     */   extends JFrame implements XYValWatcher
/*     */ {
/*     */   private Container contentsPane;
/*     */   protected JPanel statusBar;
/*     */   protected JLabel statusBarMessage;
/*     */   protected JLabel xyVal;
/*     */   private JMenuBar menuBar;
/*     */   private JMenu fileMenu;
/*     */   private JMenu propertiesMenu;
/*     */   private JMenu helpMenu;
/*     */   private JMenuItem exitItem;
/*     */   private JMenuItem borderColourItem;
/*     */   private JMenuItem graphColourItem;
/*     */   private JMenuItem axisColourItem;
/*     */   private JMenuItem xMinItem;
/*     */   private JMenuItem xMaxItem;
/*     */   private JMenuItem yMinItem;
/*     */   private JMenuItem yMaxItem;
/*     */   private JMenuItem axisResetItem;
/*     */   private JMenuItem setXAxisLabelItem;
/*     */   private JMenuItem setYAxisLabelItem;
/*     */   private JCheckBoxMenuItem showAxisLabelsItem;
/*     */   protected GraphPanel graphPanel;
/*     */   private MenuItemHandler menuHandler;
/*     */   
/*     */   public GraphFrame()
/*     */   {
/*  54 */     super("IT Grapher");
/*     */     
/*     */ 
/*  57 */     this.contentsPane = getContentPane();
/*  58 */     this.contentsPane.setLayout(new BorderLayout());
/*  59 */     ((JComponent)this.contentsPane).setBorder(new BevelBorder(1));
/*     */     
/*     */ 
/*     */ 
/*  63 */     if (this == null) throw null; addWindowListener(new GraphFrame.1(this));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  70 */     this.graphPanel = new GraphPanel(this);
/*     */     
/*     */ 
/*  73 */     this.graphPanel.addGraphListener(this);
/*     */     
/*  75 */     this.contentsPane.add(this.graphPanel, "Center");
/*     */     
/*     */ 
/*     */ 
/*  79 */     buildGUI();
/*     */     
/*  81 */     setSize(600, 400);
/*  82 */     show();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAxes(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
/*     */   {
/*  89 */     this.graphPanel.setAxisValue(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double[] getAxisValues()
/*     */   {
/*  98 */     return this.graphPanel.getAxisValues();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAxisLabels(String paramString1, String paramString2)
/*     */   {
/* 108 */     this.graphPanel.setAxisLabel(paramString1, (byte)4);
/* 109 */     this.graphPanel.setAxisLabel(paramString2, (byte)5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void buildGUI()
/*     */   {
/* 119 */     setUpStatusBar();
/* 120 */     setUpMenus();
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
/*     */   private void setUpStatusBar()
/*     */   {
/* 133 */     this.statusBar = new JPanel(new GridBagLayout());
/*     */     
/*     */ 
/* 136 */     this.statusBar.setBorder(new BevelBorder(1));
/*     */     
/*     */ 
/* 139 */     GridBagConstraints localGridBagConstraints = new GridBagConstraints();
/* 140 */     localGridBagConstraints.anchor = 17;
/*     */     
/*     */ 
/* 143 */     localGridBagConstraints.gridx = 0;
/* 144 */     localGridBagConstraints.weightx = 1.0D;
/* 145 */     localGridBagConstraints.gridwidth = 1;
/* 146 */     this.statusBarMessage = new JLabel("GraphFrame", 2);
/* 147 */     this.statusBar.add(this.statusBarMessage, localGridBagConstraints);
/*     */     
/*     */ 
/* 150 */     localGridBagConstraints.gridx = 1;
/* 151 */     localGridBagConstraints.weightx = 0.0D;
/* 152 */     localGridBagConstraints.gridwidth = 1;
/* 153 */     this.xyVal = new JLabel();
/* 154 */     this.xyVal.setForeground(Color.red);
/* 155 */     this.statusBar.add(this.xyVal, localGridBagConstraints);
/*     */     
/*     */ 
/* 158 */     this.contentsPane.add(this.statusBar, "South");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setUpMenus()
/*     */   {
/* 167 */     this.menuBar = new JMenuBar();
/*     */     
/*     */ 
/*     */ 
/* 171 */     if (this == null) throw null; this.menuHandler = new MenuItemHandler();
/*     */     
/* 173 */     setUpFileMenu();
/* 174 */     setUpPropertiesMenu();
/*     */     
/* 176 */     setJMenuBar(this.menuBar);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void setUpFileMenu()
/*     */   {
/* 183 */     this.fileMenu = new JMenu("File");
/* 184 */     this.exitItem = new JMenuItem("Exit");
/* 185 */     this.exitItem.addActionListener(this.menuHandler);
/* 186 */     this.fileMenu.add(this.exitItem);
/*     */     
/* 188 */     this.menuBar.add(this.fileMenu);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void setUpPropertiesMenu()
/*     */   {
/* 195 */     this.propertiesMenu = new JMenu("Properties");
/*     */     
/* 197 */     this.xMinItem = new JMenuItem("Set Xmin");
/* 198 */     this.propertiesMenu.add(this.xMinItem);
/* 199 */     this.xMinItem.addActionListener(this.menuHandler);
/*     */     
/* 201 */     this.xMaxItem = new JMenuItem("Set Xmax");
/* 202 */     this.propertiesMenu.add(this.xMaxItem);
/* 203 */     this.xMaxItem.addActionListener(this.menuHandler);
/*     */     
/* 205 */     this.yMinItem = new JMenuItem("Set Ymin");
/* 206 */     this.propertiesMenu.add(this.yMinItem);
/* 207 */     this.yMinItem.addActionListener(this.menuHandler);
/*     */     
/* 209 */     this.yMaxItem = new JMenuItem("Set Ymax");
/* 210 */     this.propertiesMenu.add(this.yMaxItem);
/* 211 */     this.yMaxItem.addActionListener(this.menuHandler);
/*     */     
/* 213 */     this.propertiesMenu.addSeparator();
/*     */     
/* 215 */     this.axisResetItem = new JMenuItem("Reset Axis Values");
/* 216 */     this.propertiesMenu.add(this.axisResetItem);
/* 217 */     this.axisResetItem.addActionListener(this.menuHandler);
/*     */     
/* 219 */     this.propertiesMenu.addSeparator();
/*     */     
/* 221 */     this.showAxisLabelsItem = new JCheckBoxMenuItem("Show Axis Labels", this.graphPanel.showAxisLabels);
/* 222 */     this.propertiesMenu.add(this.showAxisLabelsItem);
/* 223 */     this.showAxisLabelsItem.addActionListener(this.menuHandler);
/*     */     
/* 225 */     this.propertiesMenu.addSeparator();
/*     */     
/* 227 */     this.setXAxisLabelItem = new JMenuItem("Set X Axis Label");
/* 228 */     this.propertiesMenu.add(this.setXAxisLabelItem);
/* 229 */     this.setXAxisLabelItem.addActionListener(this.menuHandler);
/*     */     
/* 231 */     this.setYAxisLabelItem = new JMenuItem("Set Y Axis Label");
/* 232 */     this.propertiesMenu.add(this.setYAxisLabelItem);
/* 233 */     this.setYAxisLabelItem.addActionListener(this.menuHandler);
/*     */     
/* 235 */     this.menuBar.add(this.propertiesMenu);
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
/*     */   public void addGraph(Graphable paramGraphable)
/*     */   {
/* 248 */     this.graphPanel.addGraph(paramGraphable);
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
/*     */   public boolean removeGraph(Graphable paramGraphable)
/*     */   {
/* 261 */     return this.graphPanel.removeGraph(paramGraphable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Enumeration getGraphs()
/*     */   {
/* 272 */     return this.graphPanel.getGraphs();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateStatusBar(String paramString)
/*     */   {
/* 282 */     this.statusBarMessage.setText(paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateXYVals(String paramString1, String paramString2)
/*     */   {
/* 292 */     this.xyVal.setText("x = " + (paramString1.length() > 5 ? paramString1.substring(0, 5) : paramString1) + " : y = " + (paramString2.length() > 5 ? paramString2.substring(0, 5) : paramString2));
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
/*     */   protected final void getNewValue(String paramString, byte paramByte)
/*     */   {
/*     */     try
/*     */     {
/* 308 */       String str = (String)JOptionPane.showInputDialog(this, paramString, "Enter Axis Value", 1, null, null, "10");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 317 */       if (str == null) {
/* 318 */         return;
/*     */       }
/* 320 */       double d = Double.parseDouble(str);
/*     */       
/* 322 */       boolean bool = this.graphPanel.setAxisValue(d, paramByte);
/*     */       
/* 324 */       if (!bool) {
/* 325 */         JOptionPane.showMessageDialog(this, "Illegal value entered.  Please try again.", "Error", 0);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     catch (NumberFormatException localNumberFormatException)
/*     */     {
/* 332 */       JOptionPane.showMessageDialog(this, "The value entered does not appear to be a valid number", "Error", 0);
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
/*     */   protected final void getNewLabel(String paramString, byte paramByte)
/*     */   {
/* 350 */     String str = (String)JOptionPane.showInputDialog(this, paramString, "Enter Axis Label", 1, null, null, "label");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 358 */     if (str == null) {
/* 359 */       return;
/*     */     }
/* 361 */     this.graphPanel.setAxisLabel(str, paramByte);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class MenuItemHandler
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 372 */       if (paramActionEvent.getSource() == GraphFrame.this.exitItem) {
/* 373 */         System.exit(0);
/*     */       }
/* 375 */       if (paramActionEvent.getSource() == GraphFrame.this.xMinItem) {
/* 376 */         GraphFrame.this.getNewValue("Please enter a minimum value for the X axis", (byte)0);
/*     */         
/* 378 */         return;
/*     */       }
/*     */       
/* 381 */       if (paramActionEvent.getSource() == GraphFrame.this.xMaxItem) {
/* 382 */         GraphFrame.this.getNewValue("Please enter a maximum value for the X axis", (byte)1);
/*     */         
/* 384 */         return;
/*     */       }
/*     */       
/* 387 */       if (paramActionEvent.getSource() == GraphFrame.this.yMinItem) {
/* 388 */         GraphFrame.this.getNewValue("Please enter a minimum value for the Y axis", (byte)2);
/*     */         
/* 390 */         return;
/*     */       }
/*     */       
/* 393 */       if (paramActionEvent.getSource() == GraphFrame.this.yMaxItem) {
/* 394 */         GraphFrame.this.getNewValue("Please enter a maximum value for the Y axis", (byte)3);
/*     */         
/* 396 */         return;
/*     */       }
/*     */       
/* 399 */       if (paramActionEvent.getSource() == GraphFrame.this.axisResetItem) {
/* 400 */         GraphFrame.this.graphPanel.setAxisValue(0.0D, 10.0D, 0.0D, 10.0D);
/* 401 */         return;
/*     */       }
/*     */       
/* 404 */       if (paramActionEvent.getSource() == GraphFrame.this.setXAxisLabelItem) {
/* 405 */         GraphFrame.this.getNewLabel("Please enter a label for the X axis", (byte)4);
/*     */         
/* 407 */         return;
/*     */       }
/*     */       
/* 410 */       if (paramActionEvent.getSource() == GraphFrame.this.setYAxisLabelItem) {
/* 411 */         GraphFrame.this.getNewLabel("Please enter a label for the Y axis", (byte)5);
/*     */         
/* 413 */         return;
/*     */       }
/*     */       
/* 416 */       if (paramActionEvent.getSource() == GraphFrame.this.showAxisLabelsItem) {
/* 417 */         GraphFrame.this.graphPanel.setShowAxisLabels(GraphFrame.this.showAxisLabelsItem.getState());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     MenuItemHandler() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void pushChanges()
/*     */   {
/* 431 */     this.graphPanel.repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void deleteAllGraphs()
/*     */   {
/* 441 */     this.graphPanel.deleteAllGraphs();
/* 442 */     pushChanges();
/*     */   }
/*     */ }


/* Location:              C:\Users\ggsni\Downloads\it.jar!\it\GraphFrame.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */