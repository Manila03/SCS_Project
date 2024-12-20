package com.library.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Book {
    public Book() {
    }
    public Book(String title, String author, String isbn,String picture, String description, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.picture = picture;
        this.description = description;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String title;

    @Column
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private String author;

    @Column
    private String isbn;

    @Column
    private String picture;

    @Column
    private String description;

    @Column
    private String genre;
}