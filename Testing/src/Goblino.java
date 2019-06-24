
public class Goblino {

    int bombs = 0;
    
    public Goblino(int bombs) {
        this.bombs = bombs;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    @Override
    public String toString() {
        return "This goblino has " + bombs + " bombs left.";
    }
    
    public int deletSpidermen() {
        return -bombs;
    }
}
