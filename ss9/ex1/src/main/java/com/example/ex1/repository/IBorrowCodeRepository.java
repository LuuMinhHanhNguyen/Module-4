package com.example.ex1.repository;

import com.example.ex1.model.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, Integer> {
    Optional<BorrowCode> findByCodesIsAndDeleteFlagFalse(Integer code);

    List<BorrowCode> findAllByDeleteFlagIsFalse();
     boolean existsByCodesIsAndDeleteFlagIsFalse(Integer codes);

}
