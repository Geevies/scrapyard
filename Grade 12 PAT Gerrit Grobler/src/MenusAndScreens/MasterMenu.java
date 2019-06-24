package MenusAndScreens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import main.*;

public class MasterMenu extends JPanel {

    private final JButton start;
    private final JButton options;
    private final JButton profile;
    private final JButton exit;
    private final JButton help;

    public MasterMenu() {
        setPreferredSize(new Dimension(500, 400));  

        //Credits to Rob Heiser for the Panel Holder code!
        int i = 6;
        int j = 3;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
                add(panelHolder[m][n]);
            }
        }

        start = new JButton("Start Game");
        start.setPreferredSize(new Dimension(150, 60));
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.StartGame();
            }
        });

        panelHolder[1][1].add(start);

        options = new JButton("Options Menu");
        options.setPreferredSize(new Dimension(150, 60));
        options.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.OpenOptions();
            }
        });

        panelHolder[2][1].add(options);

        profile = new JButton("Profile Menu");
        profile.setPreferredSize(new Dimension(150, 60));
        profile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.OpenProfiles();
            }
        });

        panelHolder[3][1].add(profile);;

        help = new JButton("Help");
        help.setPreferredSize(new Dimension(150, 60));
        help.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.OpenHelp();
            }
        });

        panelHolder[4][1].add(help);;

        exit = new JButton("Exit Game");
        exit.setPreferredSize(new Dimension(150, 60));
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelHolder[5][1].add(exit);

        getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),
                "escapePressed");
        getActionMap().put("escapePressed",
                exitEsc);

        setVisible(true);

    }

    Action exitEsc = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

}
