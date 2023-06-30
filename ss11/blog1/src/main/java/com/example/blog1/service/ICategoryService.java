package com.example.blog1.service;

import com.example.blog1.model.Category;


import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategories();
    void save(Category newCategory);

    Category findById(Integer id);
    boolean checkIDExistence(Integer id);

    void deleteById(Integer id);
}
