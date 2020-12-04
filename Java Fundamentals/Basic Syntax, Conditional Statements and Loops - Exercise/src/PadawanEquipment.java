import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int padawansCnt = Integer.parseInt(scanner.nextLine());
        double pricePerLightsaber = Double.parseDouble(scanner.nextLine());
        double pricePerRobe = Double.parseDouble(scanner.nextLine());
        double pricePerBelt = Double.parseDouble(scanner.nextLine());

        double lightsabersTotalPrice = Math.ceil(1.1 * padawansCnt) * pricePerLightsaber;
        int FreeBelts = padawansCnt / 6;
        double beltsTotalPrice = (padawansCnt - FreeBelts) * pricePerBelt;
        double robesTotalPrice = padawansCnt * pricePerRobe;

        double finalSum = lightsabersTotalPrice + beltsTotalPrice + robesTotalPrice;

        if (finalSum > budget) {
            System.out.printf("Ivan Cho will need %.2flv more.", finalSum - budget);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.", finalSum);
        }
    }
}
