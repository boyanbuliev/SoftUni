package com.softuni.springintroex.services;

import com.softuni.springintroex.entitites.Author;
import com.softuni.springintroex.entitites.Book;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBooksAfter2000();

    Set<Author> getAllAuthorsWithBooksBefore1990();

    List<Book> getAllBooksFromGeorgePowell();
}
