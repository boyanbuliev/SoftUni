package articles2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articles = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article article = new Article(title, content, author);
            articles.add(article);
        }
        String input = scanner.nextLine();

        switch (input) {
            case "title":
                articles.stream()
                        .sorted((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()))
                        .forEach(a -> System.out.println(a));
                break;
            case "content":
                articles.stream()
                        .sorted((a1, a2) -> a1.getContent().compareTo(a2.getContent()))
                        .forEach(a -> System.out.println(a));
                break;
            case "author":
                articles.stream()
                        .sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                        .forEach(a -> System.out.println(a));
                break;
        }

    }
}
