package ru.homeproject.library.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ru.homeproject.library.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select new ru.homeproject.library.domain.Genre(g.id, g.name) from Genre g")
    Page<Genre> getGenres(int page, int pageSize, Pageable pageable);
}
