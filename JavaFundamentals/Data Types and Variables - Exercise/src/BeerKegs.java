import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String largestKeg = "";
        double largestVolume = Double.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double r = Double.parseDouble(scanner.nextLine());
            int h = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(r, 2) * h;
            if (volume > largestVolume) {
                largestVolume = volume;
                largestKeg = model;
            }
        }
        System.out.println(largestKeg);
    }
}
