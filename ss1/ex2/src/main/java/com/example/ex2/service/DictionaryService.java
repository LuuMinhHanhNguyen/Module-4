package com.example.ex2.service;

import com.example.ex2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepository iDictionaryRepository;


    @Override
    public String lookUp(String word) {
        return iDictionaryRepository.lookUp(word);
    }
}
