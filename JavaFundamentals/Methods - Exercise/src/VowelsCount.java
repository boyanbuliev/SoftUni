import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        System.out.println(volewsCount(input));
    }

    private static int volewsCount(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'a':
                    counter++;
                    break;
                case 'u':
                    counter++;
                    break;
                case 'o':
                    counter++;
                    break;
                case 'y':
                    counter++;
                    break;
                case 'e':
                    counter++;
                    break;
                case 'i':
                    counter++;
                    break;
            }
        }
        return counter;
    }
}
