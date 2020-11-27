package ru.homeproject.library.domain;

import java.util.Date;
import java.util.List;

public class Author {

    private Long id;

    private String fullName;

    private Date birthday;

    private List<Book> books;
}
