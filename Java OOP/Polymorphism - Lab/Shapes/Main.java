package Shapes;

public class Main {
    public static void main(String[] args) {

        Shape first = new Circle(12D);
        Shape second = new Rectangle(3D, 4D);
        System.out.println(first.calculateArea());
        System.out.println(first.calculatePerimeter());
        System.out.println(second.calculateArea());
        System.out.println(second.calculatePerimeter());


    }
}
