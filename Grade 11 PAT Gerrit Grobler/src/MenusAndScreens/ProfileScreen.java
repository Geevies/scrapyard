package MenusAndScreens;

import UIBackend.Profiles;
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
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import main.main;

public class ProfileScreen extends JPanel {

    public ProfileScreen() {
        initProfile();
    }

    //Method used to get everything ready, which is then called in the constructor
    public void initProfile() {
        setBackground(Color.red);
        setPreferredSize(new Dimension(600, 500));

        int i = 6;
        int j = 4;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setBackground(Color.orange);
                panelHolder[m][n].setVisible(true);
                add(panelHolder[m][n]);
            }
        }
        setVisible(true);

        getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),
                "escapePressed");
        getActionMap().put("escapePressed",
                exit);

        JLabel play1 = new JLabel("Player One:");
        panelHolder[1][1].add(play1);

        JTextField play1txt = new JTextField("Player1");
        panelHolder[1][2].add(play1txt).setPreferredSize(new Dimension(100, 50));

        JLabel play2 = new JLabel("Player Two:");
        panelHolder[2][1].add(play2);

        JTextField play2txt = new JTextField("Player2");
        panelHolder[2][2].add(play2txt).setPreferredSize(new Dimension(100, 50));

        JButton view = new JButton("View Profiles");
        view.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.ViewProfiles();
                setVisible(false);
            }
        });

        panelHolder[3][1].add(view).setPreferredSize(new Dimension(140, 70));

        JButton enter = new JButton("Set Profile Names");
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Profiles.getNames(play1txt.getText(), play2txt.getText());
                Profiles.checkNames();
            }
        });

        panelHolder[3][2].add(enter).setPreferredSize(new Dimension(140, 70));

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.KillScreen();
                main.ExitToMain();
                setVisible(false);
            }
        });
        panelHolder[4][1].add(back).setPreferredSize(new Dimension(140, 70));
    }

    Action exit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            main.KillScreen();
            main.ExitToMain();
            setVisible(false);
        }
    };

}
