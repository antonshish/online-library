package ru.homeproject.library.dao;

import org.springframework.data.domain.Page;
import ru.homeproject.library.domain.Book;

import java.util.List;

public interface BookDao {
    Book getBookById(Long id);

    Page<Book> getAllBooks(int page, int pageSize);

    Page<Book> getBooksByGenre(int page, int pageSize, Long genreId);

    Page<Book> getBooksByAuthor(int page, int pageSize, Long authorId);

    List<Book> searchBooksByKeY(String keyWord);

    byte[] getContent(Long id);

    void deleteBook(Long id);

    void saveBook(Book book);

}
