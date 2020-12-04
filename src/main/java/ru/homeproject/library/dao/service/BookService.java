package ru.homeproject.library.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homeproject.library.dao.BookDao;
import ru.homeproject.library.dao.repository.BookRepository;
import ru.homeproject.library.domain.Book;
import ru.homeproject.library.domain.Genre;

import java.util.Optional;

@Service
@Transactional
@EnableJpaRepositories
public class BookService implements BookDao {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        Optional<Book> searchResult = bookRepository.findById(id);
        if(searchResult.isPresent())
            return searchResult.get();
        return null;
    }

    @Override
    public Page<Book> getAllBooks(int page, int pageSize) {

        return bookRepository.findAllWithoutContent(PageRequest.of(page, pageSize, Sort.by("title")));
    }

    @Override
    public Page<Book> getBooksByGenre(int page, int pageSize, Long genreId) {
        return bookRepository.findByGenreId(genreId, PageRequest.of(page, pageSize, Sort.by("title")));
    }

    @Override
    public Page<Book> getBooksByAuthor(int page, int pageSize, Long authorId) {
        return bookRepository.findByAuthorId(authorId, PageRequest.of(page, pageSize, Sort.by("title")));
    }

    @Override
    public Page<Book> getBooksByKey(int page, int pageSize, String keyWord) {

        return bookRepository.findByTitleContainingIgnoreCase(keyWord,
                PageRequest.of(page, pageSize, Sort.by("title")));
    }


    @Override
    public byte[] getContent(Long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
