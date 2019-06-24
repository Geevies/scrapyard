
public class Sighting {
    private String sName;
    private int nrLarge;
    private int nrMedium;
    private int nrSmall;

    public Sighting(String sName, int nrLarge, int nrMedium, int nrSmall) {
        this.sName = sName;
        this.nrLarge = nrLarge;
        this.nrMedium = nrMedium;
        this.nrSmall = nrSmall;
    }

    public String getsName() {
        return sName;
    }
    
    public int getScore() {
        return (nrLarge * 4) + (nrMedium * 3) + (nrSmall * 2);
    }
    
    public String reformatName(String name) {
        String[] split = name.split(" ");
        return (split[0] + ", " + split[1].charAt(0)).toUpperCase();
    }

    @Override
    public String toString() {
        return reformatName(sName) + "\t" + nrLarge + "\t" + nrMedium + "\t" + nrSmall + "\n";
    }
    
    public String nameAndScore() {
        return sName + getScore();
    }
    
}
