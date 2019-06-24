package UIBackend;

import MenusAndScreens.OptionScreen;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondPlayer {

    private int rotation;
    private int vertical;
    private int horizontal;
    JPanel jill;
    //Our tank is called Jill.
    //Note: An attempt to make a "Tank" superclass was made, this brought on a whole load
    //of unfixable bugs, so the attempt was scrapped and the two tanks were split into different
    //classes, each being their own unit with shared methods.
    
    public SecondPlayer(int vertical, int horizontal, int rotation) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        //For rotation, 1 means North, 2 means East, 3 means South, 4 means West
        this.rotation = rotation;
    }

    //This is called by GameScreen to add Jill onto the new gridarea.
    public void spawn(JPanel panel) {
        jill = new JPanel();
        jill.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        spriteJill();
        panel.add(jill);
    }

    //This is called to change Jill's sprite, by placing a JLabel with an image on it onto Jill's panel.
    //The sprite used is rotation dependant.
    public void spriteJill() {
        switch (rotation) {
            case 1:
                jill.removeAll();
                JLabel spriteContainer = new JLabel(new ImageIcon("src/tankjpg/redJillup.png"));
                spriteContainer.setPreferredSize(new Dimension(53, 68));
                jill.setPreferredSize(new Dimension(53, 68));
                spriteContainer.setVisible(true);
                jill.add(spriteContainer);
                break;
            case 2:
                jill.removeAll();
                spriteContainer = new JLabel(new ImageIcon("src/tankjpg/redJillright.png"));
                spriteContainer.setPreferredSize(new Dimension(64, 60));
                jill.setPreferredSize(new Dimension(64, 60));
                spriteContainer.setVisible(true);
                jill.add(spriteContainer);
                break;
            case 3:
                jill.removeAll();
                spriteContainer = new JLabel(new ImageIcon("src/tankjpg/redJilldown.png"));
                spriteContainer.setPreferredSize(new Dimension(53, 68));
                jill.setPreferredSize(new Dimension(53, 68));
                spriteContainer.setVisible(true);
                jill.add(spriteContainer);
                break;
            case 4:
                jill.removeAll();
                spriteContainer = new JLabel(new ImageIcon("src/tankjpg/redJillleft.png"));
                spriteContainer.setPreferredSize(new Dimension(64, 60));
                jill.setPreferredSize(new Dimension(64, 60));
                spriteContainer.setVisible(true);
                jill.add(spriteContainer);
                break;
            default:
                break;
        }
    }

    //This returns Jill's rotation.
    public int getRotation() {
        return rotation;
    }

    //This returns on which row Jill is on the GameScreen.
    public int getY() {
        return vertical;
    }

    //This returns on which column Bob is on the GameScreen.
    public int getX() {
        return horizontal;
    }

    //This moves Jill forward according to her rotation on the GameScreen.
    //Jill manoevres much like a tank would.
    public void moveForward() {
        switch (rotation) {
            case 1:
                if (vertical == 0) {
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
                    vertical--;
                    break;
                }

            case 2:
                if (horizontal == OptionScreen.getGridX() - 1) {
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
                    horizontal++;
                    break;
                }

            case 3:
                if (vertical == OptionScreen.getGridY() - 1) {
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
                    vertical++;
                    break;
                }

            case 4:
                if (horizontal == 0) {
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
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
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
                    vertical++;
                    break;
                }
            case 2:
                if (horizontal == 0) {
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
                    horizontal--;
                    break;
                }
            case 3:
                if (vertical == 0) {
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
                    vertical--;
                    break;
                }
            case 4:
                if (horizontal == OptionScreen.getGridX() - 1) {
                    jill.setVisible(false);
                    break;
                } else {
                    jill.setVisible(false);
                    horizontal++;
                    break;
                }
            default:
                break;
        }
    }

    //This rotates Jill to the right, by increasing rotation by one. If five is reached
    //it means Jill has faced North, so we set her back to 1 - North.
    public void turnRight() {
        if (rotation < 4) {
            rotation++;
        } else {
            rotation = 1;
        }
        spriteJill();
    }

    //Same as turnRight, but reversed.
    public void turnLeft() {
        if (rotation > 1) {
            rotation--;
        } else {
            rotation = 4;
        }
        spriteJill();
    }
}
