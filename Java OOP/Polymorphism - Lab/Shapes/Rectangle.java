package Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        if (this.getPerimeter() != null) {
            return this.getPerimeter();
        }
        this.setPerimeter(2 * height + 2 * width);
        return this.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (this.getArea() != null) {
            return this.getArea();
        }
        super.setArea(height * width);
        return this.getArea();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
