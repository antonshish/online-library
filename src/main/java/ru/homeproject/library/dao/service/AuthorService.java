package ru.homeproject.library.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homeproject.library.dao.AuthorDao;
import ru.homeproject.library.dao.repository.AuthorRepository;
import ru.homeproject.library.domain.Author;

@Service
@Transactional
public class AuthorService implements AuthorDao {

    @Autowired
    AuthorRepository repository;

    public Page<Author> getAuthors(int page, int pageSize) {
        return repository.getAuthors(page, pageSize, PageRequest.of(page,pageSize, Sort.by("fullName")));
    }
}
