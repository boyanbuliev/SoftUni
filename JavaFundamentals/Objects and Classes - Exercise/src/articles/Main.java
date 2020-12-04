package articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        String title = input[0];
        String content = input[1];
        String author = input[2];
        Article article = new Article(title, content, author);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split(": ");
            String command = input[0];
            switch (command) {
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }
        System.out.println(article);
    }
}

