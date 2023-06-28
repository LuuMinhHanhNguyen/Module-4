package com.example.ex1.service;

import com.example.ex1.model.Book;
import com.example.ex1.model.BorrowCode;
import com.example.ex1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Autowired
    private IBorrowCodeService iBorrowCodeService;

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return iBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) throws Exception {
        Optional<Book> optionalBook = iBookRepository.findById(id);
        if(!optionalBook.isPresent()){
            throw new Exception("Cannot find this book ID!");
        }
        return iBookRepository.findById(id);
    }

    @Transactional
    @Override
    public Integer borrow(Integer id) throws Exception {
        Book borrowedBook = this.findById(id).get();
        Integer borrowedNum = borrowedBook.getBorrowed();
        borrowedBook.setBorrowed( borrowedNum + 1);
        Integer codes = (int) (Math.random() * ((99999 - 10000) + 1)) + 10000;
        while (!iBorrowCodeService.checkCodesIfNotExistence(codes)){
            codes = (int) (Math.random() * ((99999 - 10000) + 1)) + 10000;
        }
        iBorrowCodeService.save(new BorrowCode(codes,borrowedBook));
        iBookRepository.save(borrowedBook);
        return codes;
    }
}
