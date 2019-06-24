package main;

import MenusAndScreens.GameOverScreen;
import MenusAndScreens.GameScreen;
import MenusAndScreens.HelpScreen;
import MenusAndScreens.MasterMenu;
import MenusAndScreens.OptionScreen;
import MenusAndScreens.ProfileScreen;
import MenusAndScreens.ProfileView;
import UIBackend.SQLProfiles;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {

    private static JFrame base;
    private static MasterMenu menu;

    public static void main(String[] args) {
        Initialize();
    }
    
    //This sets up the JFrame we will be placing every component of the program on.
    //It also adds the "MasterMenu" onto the base JFrame.
    private static void Initialize() {
        SQLProfiles.getProfiles();
        base = new JFrame();
        base.setSize(768, 500);
        base.setTitle("Tank Battles!");
        base.setVisible(true);
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setLocationRelativeTo(null);  
        base.setResizable(false);
        menu = new MasterMenu();
        base.add(menu, 0);
        base.pack();
    }

    //Called by MasterMenu to add the GameScreen onto the JFrame
    public static void StartGame() {
        menu.setVisible(false);
        JPanel game = new GameScreen();
        base.add(game);
        base.pack();
    }

    //Called by MasterMenu to add the OptionScreen onto the JFrame
    public static void OpenOptions() {
        menu.setVisible(false);
        JPanel options = new OptionScreen();
        base.add(options);
        base.pack();
    }

    //Called by MasterMenu to add the ProfileScreen onto the JFrame
    public static void OpenProfiles() {
        menu.setVisible(false);
        JPanel profiles = new ProfileScreen();
        base.add(profiles);
        base.pack();
    }

    ////Called by MasterMenu to add the HelpScreen onto the JFrame
    public static void OpenHelp() {
        menu.setVisible(false);
        JPanel help = new HelpScreen();
        base.add(help);
        base.pack();
    }
    
    //Called by ProfileScreen to add ProfileView onto the JFrame
    public static void ViewProfiles() {
        menu.setVisible(false);
        JPanel profilesView = new ProfileView();
        base.add(profilesView);
        base.pack();
    }
    
    //Repacks every component on the JFrame, fixing its position, sprite and size.
    public static void Update() {
        base.pack();
    }
    
    public static void GameOver(String player, int health) {
        ExitToMain();
        JPanel gameOver = new GameOverScreen(player, health);
        base.add(gameOver);
        base.pack();
        menu.setVisible(false);
    }
    
    //This is often called in conjunction with KillScreen, it opens a new
    //JFrame when the old one dies, so that the program can continue functioning.
    public static void ExitToMain() {
        base.dispose();
        base = new JFrame();
        base.setSize(768, 500);
        base.setTitle("Tank Battles!");
        base.setVisible(true);
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setLocationRelativeTo(null);
        base.setResizable(false);
        menu = new MasterMenu();
        base.add(menu, 0);
        base.pack();
    }
}
