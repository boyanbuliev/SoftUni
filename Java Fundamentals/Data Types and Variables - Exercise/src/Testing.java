import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int totalCollected = 0;
        int daysWorking = 0;

        while (startingYield >= 100) {
            totalCollected += startingYield - 26;
            daysWorking++;

            startingYield -= 10;
        }
        if (totalCollected >0) {
            totalCollected -= 26;
        }
        System.out.println(daysWorking);
        System.out.println(totalCollected);
    }
}
