package PointInRectangle;

public class Rectangle {
    private int[] bottomLeft;
    private int[] topRight;

    public Rectangle(int[] coordinates) {
        this.bottomLeft = new int[]{coordinates[0], coordinates[1]};
        this.topRight = new int[]{coordinates[2], coordinates[3]};
    }

    public boolean contains(Point point) {
        return point.getX() >= bottomLeft[0] && point.getX() <= topRight[0] &&
                point.getY() >= bottomLeft[1] && point.getY() <= topRight[1];
    }
}
