package com.softuni.springintroex.controllers;

import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryServi ce = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

//        bookService.getAllBooksAfter2000().forEach(b -> System.out.println(b.getTitle()));
        bookService.getAllAuthorsWithBooksBefore1990().forEach(a ->
                System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
//        authorService.getAllAuthorsOrderedByNumberOfBooksDesc().forEach(a ->
//                System.out.printf("%s %s %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size()));
//        bookService.getAllBooksFromGeorgePowell().forEach(b ->
//                System.out.printf("%s %s %s%n", b.getTitle(), b.getReleaseDate(), b.getCopies()));
    }
}
