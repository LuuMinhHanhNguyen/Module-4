package com.example.blog1.service;

import com.example.blog1.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategories();
}
