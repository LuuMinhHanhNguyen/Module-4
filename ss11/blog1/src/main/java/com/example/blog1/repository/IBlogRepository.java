package com.example.blog1.repository;


import com.example.blog1.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingAndFlagDeleteFalse(String title);

    List<Blog> findByFlagDeleteFalse();

    List<Blog> findBlogsByCategory_IdAndFlagDeleteFalse(Integer categoryId);

}
