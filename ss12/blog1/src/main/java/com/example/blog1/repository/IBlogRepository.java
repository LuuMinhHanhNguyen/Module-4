package com.example.blog1.repository;


import com.example.blog1.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingAndFlagDeleteFalse(String title);

    List<Blog> findByFlagDeleteFalse();

    List<Blog> findBlogsByCategory_IdAndFlagDeleteFalse(Integer categoryId);

    @Query(nativeQuery = true, value = "select * from blogs limit :limit")
    List<Blog> getBlogsByPageNum(@Param("limit") int limit);
}


