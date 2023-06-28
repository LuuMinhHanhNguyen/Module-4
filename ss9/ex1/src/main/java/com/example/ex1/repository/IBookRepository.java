package com.example.ex1.repository;

import com.example.ex1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}
