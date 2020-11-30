package ru.homeproject.library.dao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.homeproject.library.config.AppConfig;
import ru.homeproject.library.domain.Book;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getBookById() {
        Book book = bookService.getBookById(7L);
        System.out.println(book.getTitle());
    }

    @Test
    public void getAllBooks() {
    }

    @Test
    public void searchBooksByKey() {
    }
}