
public class Rando {

    public static void main(String[] args) {
        Spidermen parker = new Spidermen(30);
        System.out.println(parker);
        
        Goblino norman = new Goblino(30);
        System.out.println(norman);
        
        norman.setBombs(parker.deletGoblino());
        parker.setWebs(norman.deletSpidermen());
        
        System.out.println(norman);
        System.out.println(parker);
    }
    
}