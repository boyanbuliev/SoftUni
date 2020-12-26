package com.softuni.springintroex.services.impl;

import com.softuni.springintroex.entitites.Author;
import com.softuni.springintroex.repositories.AuthorRepository;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.softuni.springintroex.constants.GlobalConstants.AUTHORS_FILE_PATH;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(AUTHORS_FILE_PATH);
        System.out.println(fileContent[0]);
        Arrays.stream(fileContent).forEach(r -> {
            Author author = new Author(r.split("\\s+"));
            authorRepository.saveAndFlush(author);
        });
    }

    @Override
    public int getAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public List<Author> getAllAuthorsOrderedByNumberOfBooksDesc() {
        return this.authorRepository.findAuthorByCountOfBooks();
    }

}
