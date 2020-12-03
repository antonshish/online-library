package ru.homeproject.library.dao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.homeproject.library.config.AppConfig;
import ru.homeproject.library.domain.Author;
import ru.homeproject.library.domain.Book;
import ru.homeproject.library.domain.Genre;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    @Qualifier("genreService")
    private GenreService genreService;

    @Autowired
    @Qualifier("authorService")
    AuthorService authorService;

    @Test
    public void getBookById() {
        Book book = bookService.getBookById(24L);
        System.out.println(book.getDescription());
        Page<Genre> page = genreService.getGenres(0, 10);
        List<Genre> list = page.getContent();

        Page<Author> authors = authorService.getAuthors(0, 10);
        List<Author> list2 = authors.getContent();
        System.out.println(list2.get(0).getFullName());
    }

    @Test
    public void getAllBooks() {
    }

    @Test
    public void searchBooksByKey() {
    }
}