package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.*;
import com.softuni.springintroex.repositories.BookRepository;
import com.softuni.springintroex.services.models.BookInfo;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.softuni.springintroex.constants.GlobalConstants.BOOKS_FILE_PATH;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookRepository bookRepository;
    private final FileUtil fileUtil;

    public BookServiceImpl(AuthorService authorService, CategoryService categoryService, BookRepository bookRepository, FileUtil fileUtil) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(BOOKS_FILE_PATH);
        Arrays.stream(fileContent).forEach(r -> {
            Book book = new Book();
            String[] params = r.split("\\s+");
            Author author = this.getRandomAuthor();
            book.setAuthor(author);
            book.setEditionType(EditionType.values()[Integer.parseInt(params[0])]);
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(params[1], pattern);
            book.setReleaseDate(releaseDate);
            book.setCopies(Integer.parseInt(params[2]));
            book.setPrice(new BigDecimal(params[3]));
            book.setAgeRestriction(AgeRestriction.values()[Integer.parseInt(params[4])]);
            String title = this.getTitle(params);
            book.setTitle(title);
            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);
            this.bookRepository.saveAndFlush(book);
        });
    }

    @Override
    public Set<Book> booksTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public Set<Book> goldenBooks() {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000);
    }

    @Override
    public Set<Book> booksByPrice(BigDecimal priceOne, BigDecimal priceTwo) {
        return this.bookRepository.findAllByPriceLessThanOrPriceAfter(priceOne, priceTwo);
    }

    @Override
    public Set<Book> notReleasedBooks(BufferedReader bf) throws IOException {
        int year = Integer.parseInt(bf.readLine());
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(startDate, endDate);
    }

    @Override
    public Set<Book> booksReleasedBeforeDate(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateBefore(date);
    }

    @Override
    public Set<Book> booksSearch(String match) {
        return this.bookRepository.findAllByTitleContainsIgnoreCase(match);
    }

    @Override
    public Set<Book> bookTitlesSearch(String match) {
        return this.bookRepository.findAllByAuthorLastNameStartsWith(match);
    }

    @Override
    public int countBooks(int number) {
        return this.bookRepository.countAllByTitle(number);
    }

    @Override
    public List<Object[]> totalBookCopies() {
        return this.bookRepository.countAllByAuthor();
    }

    @Override
    public List<Object[]> reducedBook(String title) {
        return this.bookRepository.findBookInformation(title);
    }

    @Override
    public BookInfo findByTitle(String title) {
        Book book = this.bookRepository.getByTitle(title);
        return new BookInfo(book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
    }

    @Override
    public long increaseBookCopies(BufferedReader bf) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(bf.readLine(), formatter);
        int count = Integer.parseInt(bf.readLine());
        return this.bookRepository.increaseCopiesCount(date, count) * count;
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt(authorService.getAuthorsCount()) + 1;
        return this.authorService.findAuthorById((long) randomId);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            categories.add(categoryService.findCategoryById(random.nextInt(categoryService.getCategoriesCount()) + 1));
        }
        return categories;
    }

    private String getTitle(String[] params) {
        StringBuilder title = new StringBuilder();
        for (int i = 5; i < params.length; i++) {
            title.append(params[i]).append(" ");
        }
        return title.toString().trim();
    }
}
