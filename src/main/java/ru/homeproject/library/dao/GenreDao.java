package ru.homeproject.library.dao;

import org.springframework.data.domain.Page;
import ru.homeproject.library.domain.Genre;

public interface GenreDao {
    Page<Genre> getGenres(int page, int pageSize);
}
