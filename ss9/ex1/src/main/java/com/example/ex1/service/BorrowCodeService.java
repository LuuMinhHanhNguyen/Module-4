package com.example.ex1.service;

import com.example.ex1.model.Book;
import com.example.ex1.model.BorrowCode;
import com.example.ex1.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class BorrowCodeService implements IBorrowCodeService{
    @Autowired
    private IBorrowCodeRepository iBorrowCodeRepository;
    @Autowired
    private IBookService iBookService;

    @Override
    public List<BorrowCode> getAllBorrowCodes() {
        return iBorrowCodeRepository.findAllByDeleteFlagIsFalse();
    }

    @Override
    public void save(BorrowCode borrowCode) {
        borrowCode.setBorrowDate(LocalDateTime.now());
        iBorrowCodeRepository.save(borrowCode);
    }

    @Override
    public void delete(BorrowCode borrowCode) throws Exception {
        Book returnedBook = iBookService.findById(borrowCode.getBook().getId()).get();
        returnedBook.setBorrowed(returnedBook.getBorrowed() - 1);
        borrowCode.setDeleteFlag(true);
        iBorrowCodeRepository.save(borrowCode);
    }

    @Override
    public Optional<BorrowCode> findByBorrowCodes(Integer codes) throws Exception {
        Optional<BorrowCode> optionalBorrowCode = iBorrowCodeRepository.findByCodesIsAndDeleteFlagFalse(codes);
        if(!optionalBorrowCode.isPresent()){
            throw new Exception("Invalid borrowed codes! Please try again!");
        }
        return iBorrowCodeRepository.findByCodesIsAndDeleteFlagFalse(codes);
    }

    @Override
    public boolean checkCodesIfNotExistence(Integer codes) {
        return !iBorrowCodeRepository.existsByCodesIsAndDeleteFlagIsFalse(codes);
    }

}
