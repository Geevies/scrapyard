package MenusAndScreens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class HelpScreen extends JPanel {

    public HelpScreen() {
        initHelp();
    }

    //Method used to get everything ready, which is then called in the constructor
    public void initHelp() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(700, 200));

        //BorderLayout used here because the Help TextArea did not fit into my standard panelHolder set-up
        setLayout(new BorderLayout());
        
        //Sets up the Help TextArea menu. Hardcoded because no controls are customizable yet.
        JTextArea helpTxt = new JTextArea("Objective: Hit the enemy player as many times as possible"
                + "\nMovement:"
                + "\nFirst Player (Blue):"
                + "\n W - Forwards | S - Backwards | A - Rotate Left | D - Rotate Right | Space - Fire"
                + "\n Second Player (Red):"
                + "\n Up Arrow - Forwards | Down Arrow - Backwards | Left Arrow - Rotate Left | Right Arrow - Rotate Right | Insert - Fire");
        helpTxt.setFocusable(false);
        add(helpTxt, BorderLayout.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.main.KillScreen();
                main.main.ExitToMain();
                setVisible(false);
            }
        });
        add(back, BorderLayout.SOUTH);

        setVisible(true);

        //Keybindings
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
        }
    };
}
