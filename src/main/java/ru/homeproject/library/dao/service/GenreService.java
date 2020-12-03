package ru.homeproject.library.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homeproject.library.dao.GenreDao;
import ru.homeproject.library.dao.repository.GenreRepository;
import ru.homeproject.library.domain.Genre;

@Service
@Transactional
public class GenreService implements GenreDao {

    @Autowired
    private GenreRepository genreRepository;

        public Page<Genre> getGenres(int page, int pageSize) {
            return genreRepository.getGenres(page, pageSize, PageRequest.of(page,pageSize, Sort.by("name")));
        }

}
