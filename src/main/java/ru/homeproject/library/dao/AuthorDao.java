package ru.homeproject.library.dao;

import org.springframework.data.domain.Page;
import ru.homeproject.library.domain.Author;

public interface AuthorDao {

    Page<Author> getAuthors(int page, int pageSize);
}
