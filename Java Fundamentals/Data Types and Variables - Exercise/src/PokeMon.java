import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nPower = Integer.parseInt(scanner.nextLine());
        int mDistance = Integer.parseInt(scanner.nextLine());
        int yExhaustion = Integer.parseInt(scanner.nextLine());

        int currentPower = nPower;
        int targets = 0;

        while (currentPower >= mDistance) {
            targets++;
            currentPower -= mDistance;

            if (nPower / 2 == currentPower && currentPower >= yExhaustion && yExhaustion != 0) {
                currentPower /= yExhaustion;
            }
        }
        System.out.println(currentPower);
        System.out.println(targets);
    }
}
