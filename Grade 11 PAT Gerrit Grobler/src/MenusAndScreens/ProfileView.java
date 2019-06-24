
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class ProfileView extends JPanel {

    public ProfileView() {
        initProfView();
    }
    
    //Method used to get everything ready, which is then called in the constructor
    public void initProfView() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(600, 500));

        int i = 3;
        int j = 3;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setBackground(Color.LIGHT_GRAY);
                panelHolder[m][n].setVisible(true);
                add(panelHolder[m][n]);
            }
        }
        
        JTextField profileExpln = new JTextField("Profile Name  :  Hits on Enemy");
        panelHolder[1][1].add(profileExpln).setPreferredSize(new Dimension(185, 20));
        
        JScrollPane scrollPanel = new JScrollPane();
        panelHolder[1][1].add(scrollPanel).setPreferredSize(new Dimension(185, 125));
        scrollPanel.setFocusable(false);
        
        Profiles profiles = new Profiles();
        
        JTextArea profileScreen = new JTextArea(profiles.toString());
        profileScreen.setFocusable(false);
        scrollPanel.setViewportView(profileScreen);
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.main.KillScreen();
                main.main.ExitToMain();
                setVisible(false);
            }
        });
        panelHolder[2][1].add(back).setPreferredSize(new Dimension(100, 50));
        
        setVisible(true);

        getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),
                "escapePressed");
        getActionMap().put("escapePressed",
                exit);
    }
        
        Action exit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            main.main.KillScreen();
            main.main.ExitToMain();
            setVisible(false);
    }};
}
