package ru.homeproject.library.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String fullName;

    @Column(name = "birthday")
    private Date birthday;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books;

    public Author(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Author(Long id, String fullName, Date birthday) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
