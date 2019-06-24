
public class Spidermen {

    int webs = 10;
    
    public Spidermen(int webs) {
        this.webs = webs;
    }

    public int getWebs() {
        return webs;
    }

    public void setWebs(int webs) {
        this.webs = webs;
    }

    @Override
    public String toString() {
        return "This spidermen has " + webs + " webs left.";
    }
    
    public int deletGoblino() {
        return -webs;
    }
}
