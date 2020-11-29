package ru.homeproject.library.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import ru.homeproject.library.dao.BookDao;
import ru.homeproject.library.dao.repository.BookRepository;
import ru.homeproject.library.domain.Book;

import java.util.List;

public class BookService implements BookDao {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Page<Book> getAllBooks(int page, int pageSize) {
        return null;
    }

    @Override
    public Page<Book> getBooksByGenre(int page, int pageSize, Long genreId) {
        return null;
    }

    @Override
    public Page<Book> getBooksByAuthor(int page, int pageSize, Long authorId) {
        return null;
    }

    @Override
    public List<Book> searchBooksByKeY(String keyWord) {
        return null;
    }

    @Override
    public byte[] getContent(Long id) {
        return new byte[0];
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public void saveBook(Book book) {

    }
}
