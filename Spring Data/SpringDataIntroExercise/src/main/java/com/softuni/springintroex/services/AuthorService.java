package com.softuni.springintroex.services;

import com.softuni.springintroex.entitites.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAuthorsCount();

    Author findAuthorById(Long id);

    List<Author> getAllAuthorsOrderedByNumberOfBooksDesc();
}
