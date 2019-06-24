
package pracexercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PrisonerManager {
	private Privileges priv[] = new Privileges[3];
	private Prisoner pris[] = new Prisoner[100];
	private int cntr = 0;

	public PrisonerManager() {
		try {
			Scanner scnPriv = new Scanner(new File("Privileges.txt"));
			Scanner scnPris = new Scanner(new File("Prisoners.txt"));
			scnPriv.useDelimiter(",");
			scnPris.useDelimiter(",");
			
			while (scnPriv.hasNextLine()) {
				System.out.println("");
				String tempB = scnPriv.next();
				String tempD = scnPriv.next();
				String tempV = scnPriv.next();
				scnPriv.nextLine();
			}
			scnPriv.close();
			
			while (scnPris.hasNextLine()) {
				System.out.println("");
				String tempB = scnPris.next();
				String tempD = scnPris.next();
				String tempV = scnPris.next();
				scnPris.nextLine();
			}
			scnPris.close();
				
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Privileges.txt not found!");
		}
	}
	
}
