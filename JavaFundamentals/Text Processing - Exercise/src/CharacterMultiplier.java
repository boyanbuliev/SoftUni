import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String str1 = input[0];
        String str2 = input[1];

        System.out.println(charSum(str1, str2));

    }


    public static int charSum(String str1, String str2) {
        int sum = 0;
        if (str1.length() > str2.length()) {
            for (int i = 0; i < str2.length(); i++) {
                sum += str1.charAt(i) * str2.charAt(i);
            }
            for (int i = str2.length(); i < str1.length(); i++) {
                sum += str1.charAt(i);
            }
        } else {
            for (int i = 0; i < str1.length(); i++) {
                sum += str1.charAt(i) * str2.charAt(i);
            }
            for (int i = str1.length(); i < str2.length(); i++) {
                sum += str2.charAt(i);
            }
        }
        return sum;
    }
}
