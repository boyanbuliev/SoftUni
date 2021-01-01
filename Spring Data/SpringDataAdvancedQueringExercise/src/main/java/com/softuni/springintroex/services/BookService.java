package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.AgeRestriction;
import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.services.models.BookInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;

    Set<Book> booksTitlesByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> goldenBooks();

    Set<Book> booksByPrice(BigDecimal priceOne, BigDecimal priceTwo);

    Set<Book> notReleasedBooks(BufferedReader bf) throws IOException;

    Set<Book> booksReleasedBeforeDate(LocalDate date);

    Set<Book> booksSearch(String match);

    Set<Book> bookTitlesSearch(String match);

    int countBooks(int number);

    List<Object[]> totalBookCopies();

    List<Object[]> reducedBook(String title);

    BookInfo findByTitle(String title);

    long increaseBookCopies(BufferedReader bf) throws IOException;
}
