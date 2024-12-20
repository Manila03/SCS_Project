package com.library.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Book findByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.isbn = ?1")
    Book findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE b.author = ?1")
    List<Book> findByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.genre = ?1")
    List<Book> findByGenre(String genre);

    // @Query("SELECT b FROM Book b WHERE b.author = ?1")
    // Book findByAuthor(String author);

    // @Query("SELECT b FROM Book b WHERE b.genre = ?1")
    // Book findByGenre(String genre);
}
