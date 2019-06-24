package MenusAndScreens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;

public final class OptionScreen extends JPanel {

    private static int gridX = 6;
    private static int gridY = 5;
    private static int pHealth1 = 5;
    private static int pHealth2 = 5;

    public OptionScreen() {
        initOption();
    }

    //Method used to get everything ready, which is then called in the constructor
    public void initOption() {
        setBackground(Color.gray);
        setPreferredSize(new Dimension(500, 500));

        int i = 7;
        int j = 4;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j, 1, 1));
        
        //Credits to Rob Heiser for the Panel Holder code!
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setBackground(Color.lightGray);
                panelHolder[m][n].setVisible(true);
                add(panelHolder[m][n]);
            }
        }
        setVisible(true);

        JLabel gridx1 = new JLabel("Set game");
        panelHolder[1][1].add(gridx1);
        JLabel gridx2 = new JLabel("column amount:");
        panelHolder[1][1].add(gridx2);
        JLabel gridx3 = new JLabel("(Range: 3 - 7)");
        panelHolder[1][1].add(gridx3);

        //Sets up a spinner, was previously a TextField, but being able to limit
        //the input here means we don't need to worry about incorrect values, saving
        //us some throws and catches.
        SpinnerNumberModel columns = new SpinnerNumberModel(6, 3, 7, 1);
        JSpinner gridxSpin = new JSpinner(columns);
        panelHolder[1][2].add(gridxSpin).setPreferredSize(new Dimension(50, 20));

        JLabel gridy1 = new JLabel("Set game");
        panelHolder[2][1].add(gridy1);
        JLabel gridy2 = new JLabel("row amount:");
        panelHolder[2][1].add(gridy2);
        JLabel gridy3 = new JLabel("(Range: 3 - 7)");
        panelHolder[2][1].add(gridy3);

        //Sets up a spinner, was previously a TextField, but being able to limit
        //the input here means we don't need to worry about incorrect values, saving
        //us some throws and catches.
        SpinnerNumberModel rows = new SpinnerNumberModel(5, 3, 7, 1);
        JSpinner gridySpin = new JSpinner(rows);
        panelHolder[2][2].add(gridySpin).setPreferredSize(new Dimension(50, 20));
        
        //
        JLabel health1 = new JLabel("Set Player");
        panelHolder[3][1].add(health1);
        JLabel health11 = new JLabel("One Health");
        panelHolder[3][1].add(health11);
        JLabel health111 = new JLabel("(Range: 1 - 15)");
        panelHolder[3][1].add(health111);

        //Sets up a spinner, was previously a TextField, but being able to limit
        //the input here means we don't need to worry about incorrect values, saving
        //us some throws and catches.
        SpinnerNumberModel intHealth1 = new SpinnerNumberModel(5, 1, 15, 1);
        JSpinner health1Spin = new JSpinner(intHealth1);
        panelHolder[3][2].add(health1Spin).setPreferredSize(new Dimension(50, 20));
        //

        //
        JLabel health2 = new JLabel("Set Player");
        panelHolder[4][1].add(health2);
        JLabel health22 = new JLabel("Two Health");
        panelHolder[4][1].add(health22);
        JLabel health222 = new JLabel("(Range: 1 - 15)");
        panelHolder[4][1].add(health222);

        //Sets up a spinner, was previously a TextField, but being able to limit
        //the input here means we don't need to worry about incorrect values, saving
        //us some throws and catches.
        SpinnerNumberModel intHealth2 = new SpinnerNumberModel(5, 1, 15, 1);
        JSpinner health2Spin = new JSpinner(intHealth2);
        panelHolder[4][2].add(health2Spin).setPreferredSize(new Dimension(50, 20));
        //
        JButton enter = new JButton("Set values");
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gridX = (Integer) gridxSpin.getValue();
                gridY = (Integer) gridySpin.getValue();
                pHealth1 = (Integer) health1Spin.getValue();
                pHealth2 = (Integer) health2Spin.getValue();
            }
        });
        panelHolder[5][2].add(enter).setPreferredSize(new Dimension(100, 50));

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.main.ExitToMain();
                setVisible(false);
            }
        });
        panelHolder[5][1].add(back).setPreferredSize(new Dimension(100, 50));

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),
                "escapePressed");
        getActionMap().put("escapePressed",
                exit);

    }

    //This returns the number of Columns the GameScreen will be using.
    public static int getGridX() {
        return gridX;
    }

    //This returns the number of Rows the GameScreen will be using.
    public static int getGridY() {
        return gridY;
    }
    
    public static int getHealth1() {
        return pHealth1;
    }
    
    public static int getHealth2() {
        return pHealth2;
    }

    Action exit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            main.main.ExitToMain();
            setVisible(false);
        }
    };

}
