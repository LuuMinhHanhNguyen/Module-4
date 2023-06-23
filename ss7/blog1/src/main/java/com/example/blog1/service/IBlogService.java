package com.example.blog1.service;

import com.example.blog1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void save(Blog newBlog);

    Blog findById(Integer id);
    boolean checkIDExistence(Integer id);

    void deleteById(Integer id);

    List<Blog> searchByTitle(String name);
    Page<Blog> findBlogsByCategory_IdAndFlagDeleteFalse(Integer categoryId, Pageable pageable);

}
