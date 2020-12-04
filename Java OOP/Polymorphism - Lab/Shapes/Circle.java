package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (this.getPerimeter() != null) {
            return this.getPerimeter();
        }
        this.setPerimeter(2 * radius * Math.PI);
        return this.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (this.getArea() != null) {
            return this.getArea();
        }
        this.setArea(radius * radius * Math.PI);
        return this.getArea();
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
