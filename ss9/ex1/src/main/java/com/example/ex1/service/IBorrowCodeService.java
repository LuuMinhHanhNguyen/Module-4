package com.example.ex1.service;

import com.example.ex1.model.BorrowCode;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface IBorrowCodeService {
    List<BorrowCode> getAllBorrowCodes();

    void save(BorrowCode borrowCode);
    void delete(BorrowCode borrowCode) throws Exception;

    Optional<BorrowCode> findByBorrowCodes(Integer codes) throws Exception;
    boolean checkCodesIfNotExistence(Integer codes);

}
