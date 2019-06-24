package MenusAndScreens;

import UIBackend.SQLProfiles;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import main.main;

public class ProfileScreen extends JPanel {

    private static String player1 = "Player 1";
    private static String player2 = "Player 2";
    private JComboBox profile1;
    private JComboBox profile2;

    public ProfileScreen() {
        initProfile();
    }

    //Method used to get everything ready, which is then called in the constructor
    public void initProfile() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(800, 600));

        int i = 6;
        int j = 4;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j, 1, 1));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setVisible(true);
                add(panelHolder[m][n]);
            }
        }

        for (int k = 0; k < i; k++) {
            panelHolder[k][0].setBackground(Color.blue);
            panelHolder[k][1].setBackground(Color.blue);
            panelHolder[k][2].setBackground(Color.red);
            panelHolder[k][3].setBackground(Color.red);
        }
        setVisible(true);

        profile1 = new JComboBox(SQLProfiles.getNames());
        profile1.setSelectedItem("Player1");
        panelHolder[1][1].add(profile1).setPreferredSize(new Dimension(120, 40));
        profile1.addActionListener((ActionEvent e) -> {
            if (profile1.getSelectedItem().equals("-Add Profile-")) {
                profile1.setSelectedItem("Player1");
                String pName = JOptionPane.showInputDialog("Please name the new profile below:", "New Profile");
                if (pName == null || pName.equals("")) {
                    return;
                }
                SQLProfiles.newProfile(pName, 0, "Oldie", "Red");
                main.ExitToMain();
                main.OpenProfiles();
            }
        });

        JButton x1 = new JButton("X");
        x1.setToolTipText("Delete Profile");
        panelHolder[1][1].add(x1).setPreferredSize(new Dimension(45, 40));
        x1.addActionListener((ActionEvent e) -> {
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this profile?", "Delete Profile?", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                if (profile1.getSelectedItem().equals("Player1") || profile1.getSelectedItem().equals("Player2")) {
                    JOptionPane.showMessageDialog(null, "You can't delete a default profile!");
                } else {
                    SQLProfiles.deleteProfile(profile1.getSelectedItem().toString());
                    main.ExitToMain();
                    main.OpenProfiles();
                }
            }
        });

        JButton viewProf = new JButton("View Profiles");
        panelHolder[4][1].add(viewProf).setPreferredSize(new Dimension(120, 40));
        viewProf.addActionListener((ActionEvent e) -> {
            main.ViewProfiles();
            setVisible(false);
        });

        profile2 = new JComboBox(SQLProfiles.getNames());
        profile2.setSelectedItem("Player2");
        panelHolder[1][3].add(profile2).setPreferredSize(new Dimension(120, 40));
        profile2.addActionListener((ActionEvent e) -> {
            if (profile2.getSelectedItem().equals("-Add Profile-")) {
                profile2.setSelectedItem("Player2");
                String pName = JOptionPane.showInputDialog("Please name the new profile below:", "New Profile");
                if (pName == null || pName.equals("")) {
                    return;
                }
                SQLProfiles.newProfile(pName, 0, "Oldie", "Red");
                main.ExitToMain();
                main.OpenProfiles();
            }
        });

        JButton x2 = new JButton("X");
        x2.setToolTipText("Delete Profile");
        panelHolder[1][3].add(x2).setPreferredSize(new Dimension(45, 40));
        x2.addActionListener((ActionEvent e) -> {
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this profile?", "Delete Profile?", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                if (profile2.getSelectedItem().equals("Player1") || profile2.getSelectedItem().equals("Player2")) {
                    JOptionPane.showMessageDialog(null, "You can't delete a default profile!");
                } else {
                    SQLProfiles.deleteProfile(profile2.getSelectedItem().toString());
                    main.ExitToMain();
                    main.OpenProfiles();
                }
            }
        });

        JButton createProf = new JButton("New Profile");
        panelHolder[4][2].add(createProf).setPreferredSize(new Dimension(120, 40));
        createProf.addActionListener((ActionEvent e) -> {
            main.ViewProfiles();
            setVisible(false);
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),
                "escapePressed");
        getActionMap().put("escapePressed",
                exit);
    }

    private boolean checkProfiles() {
        if (profile1.getSelectedItem().toString().equals(profile2.getSelectedItem().toString())) {
            return true;
        }
        return false;
    }

    public static String getPlayer1() {
        return player1;
    }

    public static String getPlayer2() {
        return player2;
    }

    Action exit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkProfiles() == true) {
                JOptionPane.showMessageDialog(null, "Please select differing profiles!");
            } else {
                player1 = profile1.getSelectedItem().toString();
                player2 = profile2.getSelectedItem().toString();
                main.ExitToMain();
                setVisible(false);
            }
        }
    };

}
