package com.softuni.springintroex.repositories;

import com.softuni.springintroex.entitites.Author;
import com.softuni.springintroex.entitites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate localDate);

    List<Book> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author);

    List<Book>findAllByReleaseDateBefore(LocalDate releaseDate);
}
