package com.softuni.springintroex.repositories;

import com.softuni.springintroex.entities.AgeRestriction;
import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    Set<Book> findAllByPriceLessThanOrPriceAfter(BigDecimal priceOne, BigDecimal priceTwo);

    Set<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate startDate, LocalDate endDate);

    Set<Book> findAllByReleaseDateBefore(LocalDate date);

    Set<Book> findAllByTitleContains(String match);

    Set<Book> findAllByTitleContainsIgnoreCase(String match);

    Set<Book> findAllByAuthorLastNameStartsWith(String match);

    Book getByTitle(String title);

    @Query("SELECT count(b) FROM Book b WHERE length(b.title) > :number")
    int countAllByTitle(int number);

    @Query("SELECT b.author AS author, sum(b.copies) AS sum FROM Book b GROUP BY b.author " +
            "ORDER BY sum(b.copies) DESC")
    List<Object[]> countAllByAuthor();

    @Query("SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book b WHERE b.title LIKE :title")
    List<Object[]> findBookInformation(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.copies = b.copies + :count WHERE b.releaseDate > :date")
    int increaseCopiesCount(LocalDate date, int count);
}
