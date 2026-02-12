package com.mahdirezaie.enterm_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String bookType;
    private int numberOfPages;

    // سازنده خالی برای Jackson
    public Book() {}

    public Book(String title, String author, String bookType, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.bookType = bookType;
        this.numberOfPages = numberOfPages;
    }

    // Getter & Setter ها برای نمایش درست در Postman
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getBookType() { return bookType; }
    public void setBookType(String bookType) { this.bookType = bookType; }
    public int getNumberOfPages() { return numberOfPages; }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }
}