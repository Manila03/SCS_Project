package com.library.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.entity.Book;
import com.library.demo.entity.dto.BookRequest;
import com.library.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(BookRequest bookRequest) {
        Book alreadyExist = bookRepository.findByIsbn(bookRequest.getIsbn());
        if (alreadyExist != null) {
            throw new RuntimeException("Book already exist");
        } else {
            Book newBook = new Book();
            newBook.setTitle(bookRequest.getTitle());
            newBook.setAuthor(bookRequest.getAuthor());
            newBook.setPicture(bookRequest.getPicture());
            newBook.setDescription(bookRequest.getDescription());
            newBook.setGenre( bookRequest.getGenre());
            newBook.setIsbn(bookRequest.getIsbn());
            return bookRepository.save(newBook);
        }
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(String gender) {
        return bookRepository.findByGenre(gender);
    }
}
