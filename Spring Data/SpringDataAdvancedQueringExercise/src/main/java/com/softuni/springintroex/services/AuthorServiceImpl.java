package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.Author;
import com.softuni.springintroex.repositories.AuthorRepository;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

import static com.softuni.springintroex.constants.GlobalConstants.AUTHORS_FILE_PATH;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

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
        Arrays.stream(fileContent).forEach(r -> {
            String[] names = r.split("\\s+");
            Author author = new Author(names[0], names[1]);
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
    public Set<Author> authorsSearch(String match) {
        return this.authorRepository.findAllByFirstNameEndsWith(match);
    }
}
