package ru.homeproject.library.domain;

import java.util.Date;

public class Book {

    private Long id;

    private String title;

    private int publishingYear;

    private Author author;

    private Genre genre;

    private Publisher publisher;

    private byte[] content;

    private byte[] image;

    private int pageCount;
}
