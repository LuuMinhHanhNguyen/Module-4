package com.example.blog1.service;

import com.example.blog1.model.Category;
import com.example.blog1.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return iCategoryRepository.findByFlagDeleteFalse();
    }

    @Override
    public void save(Category newCategory) {
        newCategory.setFlagDelete(false);
        iCategoryRepository.save(newCategory);
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public boolean checkIDExistence(Integer id) {
        return iCategoryRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        Category deletedCategory = this.findById(id);
        deletedCategory.setFlagDelete(true);
        iCategoryRepository.save(deletedCategory);
    }
}
