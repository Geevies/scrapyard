package UIBackend;

import MenusAndScreens.OptionScreen;
import MenusAndScreens.ProfileScreen;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstPlayer {

    private int rotation;
    private int vertical;
    private int horizontal;
    private static int health;
    private JPanel bob;
    //Our tank is called Bob.
    //Note: An attempt to make a "Tank" superclass was made, this brought on a whole load
    //of unfixable bugs, so the attempt was scrapped and the two tanks were split into different
    //classes, each being their own unit with shared methods.
    
    public FirstPlayer(int vertical, int horizontal, int rotation, int health) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        //For rotation, 1 means North, 2 means East, 3 means South, 4 means West
        this.rotation = rotation;
        this.health = health;
    }

    //This is called by GameScreen to add Bob onto the new gridarea.
    public void spawn(JPanel panel) {
        bob = new JPanel();
        bob.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        spriteBob();
        panel.add(bob);
    }

    //This is called to change Bob's sprite, by placing a JLabel with an image on it onto Bob's panel.
    //The sprite used is rotation dependant.
    public void spriteBob() {
        switch (rotation) {
            case 1:
                bob.removeAll();
                JLabel spriteContainer = new JLabel(new ImageIcon("src/tankjpg/jpgOldie/blueBobup.png"));
                spriteContainer.setPreferredSize(new Dimension(53, 68));
                bob.setPreferredSize(new Dimension(53, 68));
                spriteContainer.setVisible(true);
                bob.add(spriteContainer);
                break;
            case 2:
                bob.removeAll();
                spriteContainer = new JLabel(new ImageIcon("src/tankjpg/jpgOldie/blueBobright.png"));
                spriteContainer.setPreferredSize(new Dimension(64, 60));
                bob.setPreferredSize(new Dimension(64, 60));
                spriteContainer.setVisible(true);
                bob.add(spriteContainer);
                break;
            case 3:
                bob.removeAll();
                spriteContainer = new JLabel(new ImageIcon("src/tankjpg/jpgOldie/blueBobdown.png"));
                spriteContainer.setPreferredSize(new Dimension(53, 68));
                bob.setPreferredSize(new Dimension(53, 68));
                spriteContainer.setVisible(true);
                bob.add(spriteContainer);
                break;
            case 4:
                bob.removeAll();
                spriteContainer = new JLabel(new ImageIcon("src/tankjpg/jpgOldie/blueBobleft.png"));
                spriteContainer.setPreferredSize(new Dimension(64, 60));
                bob.setPreferredSize(new Dimension(64, 60));
                spriteContainer.setVisible(true);
                bob.add(spriteContainer);
                break;
            default:
                break;
        }
    }

    //This returns Bob's rotation.
    public int getRotation() {
        return rotation;
    }

    //This returns on which row Bob is on the GameScreen.
    public int getY() {
        return vertical;
    }

    //This returns on which column Bob is on the GameScreen.
    public int getX() {
        return horizontal;
    }

    public static int getHealth() {
        return health;
    }
    //This moves Bob forward according to his rotation on the GameScreen.
    //Bob manoevres much like a tank would.
    public void moveForward() {
        switch (rotation) {
            case 1:
                if (vertical == 0) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    vertical--;
                    break;
                }

            case 2:
                if (horizontal == OptionScreen.getGridX() - 1) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    horizontal++;
                    break;
                }

            case 3:
                if (vertical == OptionScreen.getGridY() - 1) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    vertical++;
                    break;
                }

            case 4:
                if (horizontal == 0) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    horizontal--;
                    break;
                }

            default:
                break;
        }
    }

    //Same as moveForward, but only backwards.
    public void moveBackward() {
        switch (rotation) {
            case 1:
                if (vertical == OptionScreen.getGridY() - 1) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    vertical++;
                    break;
                }
            case 2:
                if (horizontal == 0) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    horizontal--;
                    break;
                }
            case 3:
                if (vertical == 0) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    vertical--;
                    break;
                }
            case 4:
                if (horizontal == OptionScreen.getGridX() - 1) {
                    bob.setVisible(false);
                    break;
                } else {
                    bob.setVisible(false);
                    horizontal++;
                    break;
                }
            default:
                break;
        }
    }

    //This rotates Bob to the right, by increasing rotation by one. If five is reached
    //it means Bob has faced North, so we set him back to 1 - North.
    public void turnRight() {
        if (rotation < 4) {
            rotation++;
        } else {
            rotation = 1;
        }
        spriteBob();
    }

    //Same as turnRight, but reversed.
    public void turnLeft() {
        if (rotation > 1) {
            rotation--;
        } else {
            rotation = 4;
        }
        spriteBob();
    }
    
    public void loseHealth() {
        health--;
        if (health == 0) {  
            main.main.GameOver(ProfileScreen.getPlayer2(), SecondPlayer.getHealth());
        }
    }
}
