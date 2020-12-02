package ru.homeproject.library.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.homeproject.library.domain.Author;
import ru.homeproject.library.domain.Genre;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select new ru.homeproject.library.domain.Author(a.id, a.fullName, a.birthday) from Author a")
    Page<Author> getAuthors(int page, int pageSize, Pageable pageable);

}
