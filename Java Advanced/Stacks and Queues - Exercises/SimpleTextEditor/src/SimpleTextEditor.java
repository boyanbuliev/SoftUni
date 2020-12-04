import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String text = "";
        ArrayDeque<String> prevCommands = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] tokens = rawCommand.split("\\s+");
            switch (tokens[0]) {
                case "1":
                    text = append(text, tokens[1]);
                    prevCommands.push(rawCommand);
                    break;
                case "2":
                    int toDelete = text.length() - Integer.parseInt(tokens[1]);
                    String commandToPush = 2 + " " + text.substring(toDelete);
                    prevCommands.push(commandToPush);
                    text = delete(text, toDelete);
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
                    break;
                case "4":
                    String prevCommand = prevCommands.pop();
                    String[] tkns = prevCommand.split("\\s+");
                    if (tkns[0].equals("1")) {
                        int index = text.length() - tkns[1].length();
                        text = delete(text, index);
                    } else if (tkns[0].equals("2")) {
                        text = append(text, tkns[1]);
                    }
                    break;
            }
        }
    }

    public static String append(String text, String textToAdd) {
        return text + textToAdd;
    }

    public static String delete(String text, int indexToDelete) {
        return text.substring(0, indexToDelete);


    }
}
