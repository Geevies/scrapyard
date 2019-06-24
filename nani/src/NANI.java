
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NANI {
    private static String[] nani;
    private static String[] NANI;
    
    public static void main(String[] args) {
        try {
            Scanner smolGay = new Scanner(new File("nani.txt"));
            Scanner bigGay = new Scanner(new File("NANII.txt"));
            
            int bigSize = 0;
            
            String tempStor = smolGay.nextLine();
            nani = tempStor.split("#");
            smolGay.close();
            
            bigGay.useDelimiter("#");
            while (bigGay.hasNext())
            {
                bigGay.next();
                bigSize++;
            }
            bigGay.close();
            
            NANI = new String[bigSize];
            
            Scanner bigGay2 = new Scanner(new File("NANII.txt"));
            bigGay2.useDelimiter("#");
            for (int i = 0; i < bigSize; i++)
            {
                NANI[i] = bigGay2.next();
                NANI[i] = NANI[i].replace(System.getProperty("line.separator"), "");
            }
            bigGay2.close();
            
            //System.out.println("First Array");
            for (int i = 0; i < nani.length; i++)
            {
                //System.out.println(nani[i].toString());
            }
            
            //System.out.println("Second Array");
            for (int i = 0; i < NANI.length; i++)
            {
                //System.out.println(NANI[i].toString());
            }
            
            String temp;
            
            for (int i = 0; i < nani.length; i++)
            {
                for (int j = 1; j < (nani.length); j++)
                {
                    //System.out.println("blargh");
                    if (Integer.parseInt(nani[j - 1]) > Integer.parseInt(nani[j]))
                    {
                        temp = nani[j - 1];
                        nani[j - 1] = nani[j];
                        nani[j] = temp;
                    }
                }
            }
            
            for (int i = 0; i < NANI.length; i++)
            {
                for (int j = 1; j < (NANI.length); j++)
                {
                    System.out.println(j);
                    if (Integer.parseInt(NANI[j - 1]) > Integer.parseInt(NANI[j]))
                    {
                        temp = NANI[j - 1];
                        NANI[j - 1] = NANI[j];
                        NANI[j] = temp;
                    }
                }
            }
            
            System.out.println("First Sorted Array");
            for (int i = 0; i < nani.length; i++)
            {
                System.out.println(nani[i].toString());
            }
            
            System.out.println("Second Sorted Array");
            for (int i = 0; i < NANI.length; i++)
            {
                System.out.println(NANI[i].toString());
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
