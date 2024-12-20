package com.library.demo.entity.dto;

import lombok.Data;

@Data
public class BookRequest {
    private String isbn;

    private String title;

    private String author;

    private String picture;

    private String genre;
    
    private String description;
}
