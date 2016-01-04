/**
 * Created by Patrick on 2016-01-02.
 */
public class House {

    //Coordinates
    private int x;
    private int y;

    //Constructor
    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getter
    public String getPair() {
        String coordinates = x + ", " + y;
        return coordinates;
    }
}
