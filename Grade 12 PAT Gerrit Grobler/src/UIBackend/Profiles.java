package UIBackend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Profiles {

    static String firstProf = "Player1";
    static String secondProf = "Player2";

    //Constructor for construction reasons.
    public Profiles() {

    }

    //This is called by ProfileScreen to update which profiles we're working with
    public static void getNames(String profileOne, String profileTwo) {
        Profiles.firstProf = profileOne;
        Profiles.secondProf = profileTwo;
    }

    //This is also called by ProfileScreen, this checks to see if the profiles that
    //has been set actually exists, if they don't exist, we create new ones
    //by writing the textfile again, but adding the new profiles and scores to the end of it.
    public static void checkNames() {
        Scanner fileScan;
        try {
            Boolean fProfExists = false;
            Boolean sProfExists = false;

            fileScan = new Scanner(new File("Profiles.txt"));
            fileScan.useDelimiter("#");

            while (fileScan.hasNext()) {
                if (fileScan.next().equals(firstProf)) {
                    fProfExists = true;
                    break;
                }
            }
            fileScan.close();

            fileScan = new Scanner(new File("Profiles.txt"));
            fileScan.useDelimiter("#");

            while (fileScan.hasNext()) {
                if (fileScan.next().equals(secondProf)) {
                    sProfExists = true;
                    break;
                }
            }
            fileScan.close();

            if (fProfExists == false) {
                String[] temp = new String[getProfiles().length];

                for (int i = 0; i <= getProfiles().length - 1; i++) {
                    temp[i] = getProfiles()[i];
                }

                PrintWriter outFile = new PrintWriter("Profiles.txt");

                for (int i = 0; i <= temp.length - 1; i++) {
                    outFile.write(temp[i] + "#");
                }
                outFile.write(firstProf + "#0#");
                outFile.close();
            }

            if (sProfExists == false) {
                String[] temp = new String[getProfiles().length];

                for (int i = 0; i <= getProfiles().length - 1; i++) {
                    temp[i] = getProfiles()[i];
                }

                PrintWriter outFile = new PrintWriter("Profiles.txt");

                for (int i = 0; i <= temp.length - 1; i++) {
                    outFile.write(temp[i] + "#");
                }
                outFile.write(secondProf + "#0#");
                outFile.close();
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Profiles.txt not found! Redownload Tank Battles!");
        }

    }
    
    //This method is used to grab the exact string values
    //from the text file, it uses a fantastic, "robust" method
    //Credits to erickson on Stackoverflow for the code
    public static String getFileString(String path, Charset encoding) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, encoding);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Profiles.txt not found! Redownload Tank Battles!");
        }
        return "No profiles found!";
    }
    
    //This cleans up the code we get from getFileString, splitting it into an array
    //according to the hash delimiter
    public static String[] getProfiles() {
        String unsplitProfiles = getFileString("Profiles.txt", Charset.defaultCharset());
        String[] splitProfiles = unsplitProfiles.split("#");

        return splitProfiles;
    }

    //This finds the correct player's score in the text file, saves the entire text file
    //into a temporary storage, deletes the text file, rewrites the text file and
    //edits one value, the new hit value. Every. Single. Time. Someone. Is. Hit.
    //Note to self: Find a better way to store this next year.
    public void updateProfPlay1() {
        try {
            Scanner fileScan = new Scanner(new File("Profiles.txt"));

            int fileLocation = 0;

            fileScan.useDelimiter("#");

            while (fileScan.hasNext()) {

                if (fileScan.next().equals(firstProf)) {
                    fileLocation++;
                    break;
                } else {
                    fileLocation++;
                }
            }
            fileScan.close();

            String[] temp = new String[getProfiles().length];
            for (int i = 0; i <= getProfiles().length - 1; i++) {
                temp[i] = getProfiles()[i];
            }

            PrintWriter outFile = new PrintWriter("Profiles.txt");

            for (int i = 0; i <= temp.length - 1; i++) {
                if (i == fileLocation) {
                    outFile.write(Integer.toString(Integer.parseInt(temp[i]) + 1) + "#");
                } else {
                    outFile.write(temp[i] + "#");
                }
            }
            outFile.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Profiles.txt not found! Redownload Tank Battles!");
        }
    }

    //This finds the correct player's score in the text file, saves the entire text file
    //into a temporary storage, deletes the text file, rewrites the text file and
    //edits one value, the new hit value. Every. Single. Time. Someone. Is. Hit.
    //This one is for player two.
    //Note to self: Find a better way to store this next year.
    public void updateProfPlay2() {
        try {
            Scanner fileScan = new Scanner(new File("Profiles.txt"));

            int fileLocation = 0;

            fileScan.useDelimiter("#");

            while (fileScan.hasNext()) {

                if (fileScan.next().equals(secondProf)) {
                    fileLocation++;
                    break;
                } else {
                    fileLocation++;
                }
            }
            fileScan.close();

            String[] temp = new String[getProfiles().length];
            for (int i = 0; i <= getProfiles().length - 1; i++) {
                temp[i] = getProfiles()[i];
            }

            PrintWriter outFile = new PrintWriter("Profiles.txt");

            for (int i = 0; i <= temp.length - 1; i++) {
                if (i == fileLocation) {
                    outFile.write(Integer.toString(Integer.parseInt(temp[i]) + 1) + "#");
                } else {
                    outFile.write(temp[i] + "#");
                }
            }
            outFile.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Profiles.txt not found! Redownload Tank Battles!");
        }
    }

    //This overrides the usual toString method, this is only used in the "ProfileView"
    //JPanel, so that the output on the JTextArea doesn't look like garbage.
    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder("");
        for (int i = 0; i < getProfiles().length; i++) {
            if (i == 1) {
                finalString.append(getProfiles()[i]).append("\n");
            } else if (i % 2 == 0) {
                finalString.append(getProfiles()[i]).append(": ");
            } else {
                finalString.append(getProfiles()[i]).append("\n");
            }
        }

        return finalString.toString();
    }

}
