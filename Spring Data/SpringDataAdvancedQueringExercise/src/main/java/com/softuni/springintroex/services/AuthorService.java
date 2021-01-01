package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.Author;

import java.io.IOException;
import java.util.Set;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAuthorsCount();

    Author findAuthorById(Long id);

    Set<Author> authorsSearch(String match);
}
