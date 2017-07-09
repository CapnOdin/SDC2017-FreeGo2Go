package software.unf.dk.freego2go;

/**
 * Created by deltager on 09-07-17.
 */

public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if(o == null || Point.class != o.getClass())
            return false;
        return x == ((Point) o).x && y == ((Point) o).y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
