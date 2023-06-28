package com.example.ex1.service;

import com.example.ex1.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    void save(Book book);

    List<Book> getAllBooks();

    Optional<Book> findById(Integer id) throws Exception;

    Integer borrow(Integer id) throws Exception;
}
