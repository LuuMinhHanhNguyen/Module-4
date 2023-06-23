package com.example.blog1.service;

import com.example.blog1.model.Category;
import com.example.blog1.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return iCategoryRepository.findAll();
    }
}
