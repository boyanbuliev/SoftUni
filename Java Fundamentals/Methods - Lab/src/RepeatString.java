import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String output = inputTimesN(input, n);
        System.out.println(output);
    }

    private static String inputTimesN(String input, int n) {
        String repeats = "";
        for (int i = 0; i < n; i++) {
            repeats += input;
        }
        return repeats;
    }
}
