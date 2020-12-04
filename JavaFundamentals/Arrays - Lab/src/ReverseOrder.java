import java.util.Scanner;

public class ReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[Integer.parseInt(scanner.nextLine())];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]+" ");
        }
    }
}
