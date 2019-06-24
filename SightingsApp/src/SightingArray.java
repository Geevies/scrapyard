
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SightingArray {

    Sighting[] sights = new Sighting[50];
    private int sightSize = 0;

    public SightingArray() {
        Scanner fileScn;
        try {
            fileScn = new Scanner(new File("Sightings.txt"));
            String nakedLine;
            String name;
            int large;
            int medium;
            int small;
            while (fileScn.hasNextLine()) {
                nakedLine = fileScn.nextLine();
                String[] unformattedStrings = nakedLine.split("#");
                name = unformattedStrings[0];
                large = Integer.parseInt(unformattedStrings[1]);
                medium = Integer.parseInt(unformattedStrings[2]);
                small = Integer.parseInt(unformattedStrings[3]);
                sights[sightSize] = new Sighting(name, large, medium, small);
                sightSize++;
            }
            fileScn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sightings.txt not found! Reinstall program!");
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < sightSize; i++) {
            output = output + sights[i].toString();
        }
        return output;
    }
    
    public void sort() {
        for (int i = sightSize - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sights[j].getScore() < sights[j + 1].getScore()) {
                    Sighting temp = sights[j];
                    sights[j] = sights[j + 1];
                    sights[j + 1] = temp;
                }
            }
        }
    }
    
    public String top5() {
        String output = "";
        sort();
        for (int i = 0; i < 5; i++) {
            output = output + sights[i];
        }
        return output;
    }
    
    public String search(String surname) {
        for (int i = 0; i < sightSize; i++) {
            String[] splitSName = sights[i].getsName().split(" ");
            if (splitSName[1].equals(surname)) {
                return sights[i].toString();
            }
        }
        return "Person not found!";
    }
}
