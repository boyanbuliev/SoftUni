import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        StringBuilder result = new StringBuilder();


        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != '>') {
                result.append(currentChar);
                input.deleteCharAt(i);
                i--;
            } else {
                counter += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                result.append(currentChar);
                input.deleteCharAt(i);
                i--;
                while (counter > 0&&input.length()>0) {
                    if (input.charAt(i + 1) != '>') {
                        input.deleteCharAt(i + 1);
                        counter--;
                    } else {
                        counter += Integer.parseInt(String.valueOf(input.charAt(i + 2)));
                        result.append(currentChar);
                        input.deleteCharAt(i + 1);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
