package MenusAndScreens;

import UIBackend.FirstPlayer;
import UIBackend.Profiles;
import UIBackend.SecondPlayer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public final class GameScreen extends JPanel {

    int i = OptionScreen.getGridY();
    int j = OptionScreen.getGridX();
    JPanel[][] panelHolder = new JPanel[i][j];
    int m;
    int n;
    FirstPlayer first = new FirstPlayer(i - i, j - j, 3);
    SecondPlayer second = new SecondPlayer(i - 1, j - 1, 1);
    Profiles profiles = new Profiles();

    public GameScreen() {
        initGame();
    }
    
    //Method used to get everything ready, which is then called in the constructor
    public void initGame() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(700, 600));

        setLayout(new GridLayout(i, j, 5, 5));

        //Credits to Rob Heiser for the Panel Holder code!
        //This adds panels onto the original panel, creating a gridbaglayout effect without the hassle
        for (m = 0; m < i; m++) {
            for (n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setVisible(true);
                add(panelHolder[m][n]);
            }
        }
        
        //Setting up keybindings for gameplay + escape to exit
        
        getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),
                "escapePressed");
        getActionMap().put("escapePressed",
                exit);

        getInputMap().put(KeyStroke.getKeyStroke("W"),
                "wPressed");
        getActionMap().put("wPressed",
                firstForward);

        getInputMap().put(KeyStroke.getKeyStroke("S"),
                "sPressed");
        getActionMap().put("sPressed",
                firstBackward);

        getInputMap().put(KeyStroke.getKeyStroke("D"),
                "dPressed");
        getActionMap().put("dPressed",
                firstRight);

        getInputMap().put(KeyStroke.getKeyStroke("A"),
                "aPressed");
        getActionMap().put("aPressed",
                firstLeft);

        getInputMap().put(KeyStroke.getKeyStroke("SPACE"),
                "spacePressed");
        getActionMap().put("spacePressed",
                firstFire);

        getInputMap().put(KeyStroke.getKeyStroke("UP"),
                "upPressed");
        getActionMap().put("upPressed",
                secondForward);

        getInputMap().put(KeyStroke.getKeyStroke("DOWN"),
                "downPressed");
        getActionMap().put("downPressed",
                secondBackward);

        getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),
                "rightPressed");
        getActionMap().put("rightPressed",
                secondRight);

        getInputMap().put(KeyStroke.getKeyStroke("LEFT"),
                "leftPressed");
        getActionMap().put("leftPressed",
                secondLeft);

        getInputMap().put(KeyStroke.getKeyStroke("INSERT"),
                "insertPressed");
        getActionMap().put("insertPressed",
                secondFire);

        first.spawn(panelHolder[first.getY()][first.getX()]);

        second.spawn(panelHolder[second.getY()][second.getX()]);
    }

    Action exit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            main.main.KillScreen();
            main.main.ExitToMain();
            setVisible(false);
        }
    };

    Action firstForward = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            first.moveForward();
            first.spawn(panelHolder[first.getY()][first.getX()]);
            main.main.Update();
        }
    };

    Action firstBackward = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            first.moveBackward();
            first.spawn(panelHolder[first.getY()][first.getX()]);
            main.main.Update();
        }
    };

    Action firstRight = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            first.turnRight();
            main.main.Update();
        }
    };

    Action firstLeft = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            first.turnLeft();
            main.main.Update();
        }
    };
    
    //Receives information from the FirstPlayer class to determine the rotation of the tank
    //on the game screen, which then changes in which direction it fires.
    //It then receives data from the SecondPlayer class to see if the second player was hit.
    
    Action firstFire = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (first.getRotation()) {
                case 1:
                    for (int k = first.getY(); k > -1; k--) {
                        panelHolder[k][first.getX()].setBackground(Color.CYAN);
                        if (k == second.getY() && first.getX() == second.getX()) {
                            panelHolder[second.getY()][second.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay1();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                case 2:
                    for (int k = first.getX(); k < OptionScreen.getGridX(); k++) {
                        panelHolder[first.getY()][k].setBackground(Color.CYAN);
                        if (k == second.getX() && first.getY() == second.getY()) {
                            panelHolder[second.getY()][second.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay1();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                case 3:
                    for (int k = first.getY(); k < OptionScreen.getGridY(); k++) {
                        panelHolder[k][first.getX()].setBackground(Color.CYAN);
                        if (k == second.getY() && first.getX() == second.getX()) {
                            panelHolder[second.getY()][second.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay1();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                case 4:
                    for (int k = first.getX(); k > -1; k--) {
                        panelHolder[first.getY()][k].setBackground(Color.CYAN);
                        if (k == second.getX() && first.getY() == second.getY()) {
                            panelHolder[second.getY()][second.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay1();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };

    Action secondForward = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second.moveForward();
            second.spawn(panelHolder[second.getY()][second.getX()]);
            main.main.Update();
        }
    };

    Action secondBackward = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second.moveBackward();
            second.spawn(panelHolder[second.getY()][second.getX()]);
            main.main.Update();
        }
    };

    Action secondRight = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second.turnRight();
            main.main.Update();
        }
    };

    Action secondLeft = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second.turnLeft();
            main.main.Update();
        }
    };

    
    //Receives information from the SecondPlayer class to determine the rotation of the tank
    //on the game screen, which then changes in which direction it fires.
    //It then receives data from the FirstPlayer class to see if the second player was hit.
    
    Action secondFire = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (second.getRotation()) {
                case 1:
                    for (int k = second.getY(); k > -1; k--) {
                        panelHolder[k][second.getX()].setBackground(Color.MAGENTA);
                        if (k == first.getY() && second.getX() == first.getX()) {
                            panelHolder[first.getY()][first.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay2();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                case 2:
                    for (int k = second.getX(); k < OptionScreen.getGridX(); k++) {
                        panelHolder[second.getY()][k].setBackground(Color.MAGENTA);
                        if (k == first.getX() && second.getY() == first.getY()) {
                            panelHolder[first.getY()][first.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay2();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                case 3:
                    for (int k = second.getY(); k < OptionScreen.getGridY(); k++) {
                        panelHolder[k][second.getX()].setBackground(Color.MAGENTA);
                        if (k == first.getY() && second.getX() == first.getX()) {
                            panelHolder[first.getY()][first.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay2();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                case 4:
                    for (int k = second.getX(); k > -1; k--) {
                        panelHolder[second.getY()][k].setBackground(Color.MAGENTA);
                        if (k == first.getX() && second.getY() == first.getY()) {
                            panelHolder[first.getY()][first.getX()].setBackground(Color.DARK_GRAY);
                            profiles.updateProfPlay2();
                            System.out.println("Hit!");
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };
}
