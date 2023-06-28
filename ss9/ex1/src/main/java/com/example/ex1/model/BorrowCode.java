package com.example.ex1.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrow_code")
public class BorrowCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codes;

    @ManyToOne
    private Book book;

    @Column(name = "delete_flag")
    private boolean deleteFlag;


    private LocalDateTime borrowDate;

    @Column()
    private LocalDateTime returnDate;

    public BorrowCode() {

    }

    public BorrowCode(Integer codes, Book book) {
        this.codes = codes;
        this.book = book;
    }


    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodes() {
        return codes;
    }

    public void setCodes(Integer codes) {
        this.codes = codes;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
