package ru.homeproject.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
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

import java.util.List;

@Controller
@RequestMapping("/")
@Lazy
public class HelloController {

    @Autowired
    BookService bookService;

    @Autowired
    GenreService service;

    @Autowired
    AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(Model model){
        Page<Genre> genrePage = service.getGenres(0,10);
        List<Genre> genreList = genrePage.getContent();
        model.addAttribute("genres", genreList);

        Page<Author> authorPage = authorService.getAuthors(0,9);
        List<Author> authorList = authorPage.getContent();
        model.addAttribute("authors", authorList);

        return "index";
    }

    @GetMapping("/genre/books")
    public String test(@RequestParam("genreId") int genreId, Model model){

        return "productdetail";
    }

    @GetMapping("/author/books")
    public String test1(@RequestParam("authorId") int genreId, Model model){

        return "productdetail";
    }


}
