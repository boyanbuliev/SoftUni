package com.softuni.springintroex.services.impl;

import com.softuni.springintroex.entitites.Author;
import com.softuni.springintroex.entitites.Book;
import com.softuni.springintroex.entitites.Category;
import com.softuni.springintroex.entitites.enums.AgeRestriction;
import com.softuni.springintroex.entitites.enums.EditionType;
import com.softuni.springintroex.repositories.BookRepository;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.softuni.springintroex.constants.GlobalConstants.BOOKS_FILE_PATH;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookRepository bookRepository;
    private final FileUtil fileUtil;

    @Autowired
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
    public List<Book> getAllBooksAfter2000() {
        return this.bookRepository.findAllByReleaseDateAfter(LocalDate.of(2000, 12, 31));
    }

    public Set<Author> getAllAuthorsWithBooksBefore1990() {
        return this.bookRepository.findAllByReleaseDateBefore(LocalDate.of(1990, 1, 1))
                .stream().map(Book::getAuthor).collect(Collectors.toSet());
    }

    @Override
    public List<Book> getAllBooksFromGeorgePowell() {
        return this.bookRepository.findAllByAuthorOrderByReleaseDateDescTitleAsc(authorService.findAuthorById(4L));
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

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt(authorService.getAuthorsCount()) + 1;
        return this.authorService.findAuthorById((long) randomId);
    }
}
