package MenusAndScreens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public final class GameOverScreen extends JPanel {
    
    private String player;
    private int health;

    public GameOverScreen(String player, int health) {
        this.player = player;
        this.health = health;
        initGameOver();
    }

    //Method used to get everything ready, which is then called in the constructor
    public void initGameOver() {
        setBackground(Color.gray);
        setPreferredSize(new Dimension(500, 400));

        int i = 5;
        int j = 3;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j, 1, 1));
        
        //Credits to Rob Heiser for the Panel Holder code!
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setBackground(Color.red);
                panelHolder[m][n].setVisible(true);
                add(panelHolder[m][n]);
            }
        }
        setVisible(true);
        
        JLabel winner = new JLabel(player);
        panelHolder[1][1].add(winner);
        
        int value = (int) (Math.random() * 10);
        String message = "";
        
        switch (value) {
            case 0:
                message = "annihilated the opposition.";
                break;
            case 1:
                message = "ravaged the enemy.";
                break;
            case 2:
                message = "wiped the floor with the loser.";
                break;
            case 3:
                message = "destroyed the other tank";
                break;
            case 4:
                message = "was quicker on the trigger.";
                break;
            case 5:
                message = "killed their antagonist.";
                break;
            default:
                message = "is the Tank Battles champ.";  
                break;
        }
        
        JLabel winner1 = new JLabel(message);
        panelHolder[1][1].add(winner1); 
        
        JLabel winnerH = new JLabel(player);
        panelHolder[2][1].add(winnerH);
        
        JLabel winnerH1 = new JLabel("had " + health + " points of health left.");
        panelHolder[2][1].add(winnerH1);
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.main.ExitToMain();
                setVisible(false);
            }
        });
        panelHolder[3][1].add(back).setPreferredSize(new Dimension(100, 50));

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),
                "escapePressed");
        getActionMap().put("escapePressed",
                exit);

    }

    Action exit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            main.main.ExitToMain();
            setVisible(false);
        }
    };

}