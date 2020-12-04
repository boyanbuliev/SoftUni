package PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int[] cords) {
        this.x = cords[0];
        this.y = cords[1];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
