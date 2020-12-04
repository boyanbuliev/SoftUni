import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Length: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double h = Double.parseDouble(scanner.nextLine());
        double v = (a * b * h) / 3;
        System.out.printf("Pyramid Volume: %.2f", v);

    }
}
