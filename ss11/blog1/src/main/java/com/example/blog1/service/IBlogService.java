package com.example.blog1.service;

import com.example.blog1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog newBlog);

    Blog findById(Integer id);
    boolean checkIDExistence(Integer id);

    void deleteById(Integer id);

    List<Blog> searchByTitle(String name);
    List<Blog> findBlogsByCategory_IdAndFlagDeleteFalse(Integer categoryId);

}
