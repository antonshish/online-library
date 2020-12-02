package ru.homeproject.library.dao.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.homeproject.library.domain.Book;
import ru.homeproject.library.domain.Genre;

import java.util.List;

@Repository()
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select new ru.homeproject.library.domain.Book(b.id, b.title, b.publishingYear, b.author, b.genre, b.publisher," +
            " b.image, b.pageCount) from Book b")
    Page<Book> findAllWithoutContent(Pageable pageable);

    @Query("select new ru.homeproject.library.domain.Book(b.id, b.image) from Book b")
    Page<Book> findOnlyImage(Pageable pageable);

    Page<Book> findByAuthorFullNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Query("update Book b set b.content=:content where b.id =:id")
    void updateContent(@Param("content")byte[] content, @Param("id") Long id);

    @Query("select b.content from Book b where b.id =:id")
    byte[] getContent(@Param("id") Long id);

    Page<Book> findByGenreId(Long id, Pageable pageable);

    Page<Book> findByAuthorId(Long id, Pageable pageable);




}
