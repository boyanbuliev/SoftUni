import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(createRowOfRhombus(n, true) + createRowOfRhombus(n, false));

    }

    public static String createRowOfRhombus(int n, boolean topHalf) {
        StringBuilder out = new StringBuilder();
        for (int row = 1; row <= n; row++) {
            int spaceCount = topHalf ? n - row : row;
            int starsCount = topHalf ? row : n - row;
            out.append(repeatSequence(' ', spaceCount));
            out.append(repeatSequence("* ", starsCount));
            out.append(System.lineSeparator());
        }
        return out.toString();
    }

    private static String repeatSequence(String str, int count) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < count; i++) {
            out.append(str);
        }
        return out.toString();
    }

    public static String repeatSequence(char symbol, int count) {
        return repeatSequence(String.valueOf(symbol), count);
    }
}
