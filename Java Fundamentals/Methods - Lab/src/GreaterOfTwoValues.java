import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        switch (input) {
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(num1, num2));
                break;
            case "char":
                char c1 = scanner.nextLine().charAt(0);
                char c2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(c1, c2));
                break;
            case "string":
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();
                System.out.println(getMax(s1, s2));
                break;
        }
    }

    private static String getMax(String s1, String s2) {
        if (s1.compareTo(s2) >= 0) {
            return s1;
        }
        return s2;
    }
    private static char getMax(char c1, char c2) {
        return (char) Math.max(c1, c2);
    }

    private static int getMax(int num1, int num2) {
        return Math.max(num1, num2);
    }
}
