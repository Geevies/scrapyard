
package data.validation;

import javax.swing.JFrame;

public class DataValidation {

	public static void main(String[] args) {
		JFrame base = new JFrame();
        base = new JFrame();
        base.setSize(800, 600);
        base.setTitle("Data Validation!");
        base.setVisible(true);
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setLocationRelativeTo(null);  
        base.setResizable(true);
		EmployeeEnter enter = new EmployeeEnter();
        base.add(enter, 0);
        base.pack();
		
	}
	
}
