
import javax.swing.JOptionPane;


public class SightingsApp {

    public static void main(String[] args) {
        SightingArray sighting = new SightingArray();
        System.out.println(sighting.toString());
        System.out.println(sighting.top5());
        System.out.println(sighting.search(JOptionPane.showInputDialog(null, "Insert surname")));
    }
    
}
