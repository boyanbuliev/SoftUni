import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int brokenHeadsets = 0;
        int brokenMouses = 0;
        int brokenKeyboards = 0;
        int brokenDisplays = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                brokenHeadsets++;
                brokenMouses++;
                brokenKeyboards++;
                if (brokenKeyboards % 2 == 0) {
                    brokenDisplays++;
                }
            } else if (i % 3 == 0) {
                brokenMouses++;
            } else if (i % 2 == 0) {
                brokenHeadsets++;
            }
        }
        double totalRageExpenses = brokenHeadsets * headsetPrice + brokenMouses * mousePrice
                + brokenKeyboards * keyboardPrice + brokenDisplays * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", totalRageExpenses);
    }
}
