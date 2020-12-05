package ru.homeproject.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.homeproject.library.dao.service.AuthorService;
import ru.homeproject.library.dao.service.BookService;
import ru.homeproject.library.dao.service.GenreService;
import ru.homeproject.library.domain.Author;
import ru.homeproject.library.domain.Book;
import ru.homeproject.library.domain.Genre;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/")
@Lazy
public class MainController {

    @Autowired
    BookService bookService;

    @Autowired
    GenreService genreService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/image")
    public void getBookImage(@RequestParam("bookId") Long bookId, HttpServletResponse response) {
        response.setContentType("image/jpeg, image/png");
        response.setHeader("Cache-Control", "max-age=2628000");
        Book book = bookService.getBookById(bookId);
        byte[] bookImage = book.getImage();
        try(OutputStream out = response.getOutputStream()) {
            out.write(bookImage);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/showBook")
    public void getBookContent(@RequestParam("bookId") Long bookId, HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.setHeader("Cache-Control", "post-check=0");
        Book book = bookService.getBookById(bookId);
        byte[] bookContent = book.getContent();
        try(OutputStream out = response.getOutputStream()) {
            out.write(bookContent);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String welcomePage(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model){

        addGenresAndAuthors(model);

        Page<Book> bookPage = bookService.getAllBooks(page, 9);
        List<Book> bookList = bookPage.getContent();
        model.addAttribute("books", bookList);
        return "index";
    }

    private void addGenresAndAuthors(Model model) {
        Page<Genre> genrePage = genreService.getGenres(0,10);
        List<Genre> genreList = genrePage.getContent();
        model.addAttribute("genres", genreList);

        Page<Author> authorPage = authorService.getAuthors(0,10);
        List<Author> authorList = authorPage.getContent();
        model.addAttribute("authors", authorList);
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam(value = "keyword", defaultValue = "none") String keyWord,
                       @RequestParam(value = "genreId", defaultValue = "-1") long genreId,
                       @RequestParam(value = "authorId", defaultValue = "-1") long authorId,
                       Model model){
        addGenresAndAuthors(model);
        if(!keyWord.equals("none")) {
            Page<Book> bookPage = bookService.getBooksByKey(0, 15, keyWord);
            List<Book> bookList = bookPage.getContent();
            model.addAttribute("books", bookList);
        }
        if(genreId != -1) {
            Page<Book> bookPage = bookService.getBooksByGenre(0, 15, genreId);
            List<Book> bookList = bookPage.getContent();
            model.addAttribute("books", bookList);
        }
        if(authorId != -1) {
            Page<Book> bookPage = bookService.getBooksByAuthor(0, 15, authorId);
            List<Book> bookList = bookPage.getContent();
            model.addAttribute("books", bookList);
        }
        return "products";
    }
    @GetMapping("/book")
    public String bookPage(@RequestParam("bookId") long bookId, Model model) {
        addGenresAndAuthors(model);
        Book book = bookService.getBookById(bookId);

        model.addAttribute("book", book);
        return "productdetail";
    }


    @GetMapping("/author/books")
    public String test1(@RequestParam("authorId") int genreId, Model model){

        return "productdetail";
    }


}
