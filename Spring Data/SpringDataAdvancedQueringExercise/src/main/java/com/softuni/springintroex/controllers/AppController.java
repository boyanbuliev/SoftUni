package com.softuni.springintroex.controllers;

import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class AppController implements CommandLineRunner {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;
    BufferedReader bf;

    @Autowired
    public AppController(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
        bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

//        Ex. 1
//        this.bookService.booksTitlesByAgeRestriction(AgeRestriction.valueOf(bf.readLine().toUpperCase()))
//                .forEach(b -> System.out.println(b.getTitle()));
//        Ex. 2
//        this.bookService.goldenBooks().forEach(b -> System.out.println(b.getTitle()));
//        Ex. 3
//        this.bookService.booksByPrice(new BigDecimal(5), new BigDecimal(40))
//                .forEach(b -> System.out.println(b.getTitle() + " " + b.getPrice()));
//        Ex. 4
//        this.bookService.notReleasedBooks(bf)
//                .forEach(b -> System.out.println(b.getTitle()));
//        Ex. 5
//        String releaseDate = bf.readLine();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate date = LocalDate.parse(releaseDate, formatter);
//        this.bookService.booksReleasedBeforeDate(date)
//                .forEach(b -> System.out.println(b.getTitle()+" "+ b.getPrice()));
//        Ex. 6
//        String match = bf.readLine();
//        this.authorService.authorsSearch(match)
//                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
//        Ex. 7
//        String match = bf.readLine();
//        this.bookService.booksSearch(match)
//                .forEach(b -> System.out.println(b.getTitle()));
//        Ex. 8
//            String match = bf.readLine();
//            this.bookService.bookTitlesSearch(match)
//                    .forEach(b-> System.out.println(b.getTitle()));
//        Ex. 9
//        int number = Integer.parseInt(bf.readLine());
//        System.out.println(this.bookService.countBooks(number));
//        Ex. 10
//        this.bookService.totalBookCopies()
//                .forEach(p -> {
//                    Author author = (Author) p[0];
//                    System.out.printf("%s %s - %s%n", author.getFirstName(), author.getLastName(), p[1]);
//                });
//        Ex. 11
//        String title = bf.readLine().trim();
//        this.bookService.reducedBook(title)
//                .forEach(i -> System.out.printf("%s %s %s %s%n", i[0], i[1], i[2], i[3]));
//        BookInfo book = this.bookService.findByTitle(title);
//        System.out.printf("%s %s %s %.2f%n", book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
//        Ex. 12
        System.out.println(this.bookService.increaseBookCopies(bf));
    }
}
