package com.example.ex2.repository;

import org.springframework.stereotype.Repository;


public interface IDictionaryRepository {
    String lookUp(String word);
}
