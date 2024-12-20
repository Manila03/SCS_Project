package com.library.demo.service;

import java.util.List;
import java.util.Optional;

import com.library.demo.entity.Book;
import com.library.demo.entity.dto.BookRequest;

public interface BookService {
    public Book saveBook(BookRequest bookRequest);

    Book getBookByTitle(String title);

    List<Book> getBooksByGenre(String gender);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooks();

}
