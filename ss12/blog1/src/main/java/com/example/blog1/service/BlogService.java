package com.example.blog1.service;

import com.example.blog1.model.Blog;
import com.example.blog1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {

        return iBlogRepository.findByFlagDeleteFalse();
    }

    @Override
    public void save(Blog newBlog) {
        newBlog.setDate(LocalDateTime.now());
        newBlog.setFlagDelete(false);
        iBlogRepository.save(newBlog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public boolean checkIDExistence(Integer id) {
        return iBlogRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        Blog deletedBlog = this.findById(id);
        deletedBlog.setFlagDelete(true);
        iBlogRepository.save(deletedBlog);
    }

    @Override
    public List<Blog> searchByTitle(String title) {
        return iBlogRepository.findByTitleContainingAndFlagDeleteFalse(title);
    }

    @Override
    public List<Blog> findBlogsByCategory_IdAndFlagDeleteFalse(Integer categoryId) {
        return iBlogRepository.findBlogsByCategory_IdAndFlagDeleteFalse(categoryId);
    }



    @Override
    public List<Blog> getBlogsByPageNum(int limit) {
//        List<Blog> blogs = new ArrayList<>();
//        List<Blog> allBlog = iBlogRepository.findAll();
//        System.out.println(allBlog);
//        int start =  pageNum == 0 ? 0 : ((pageNum * 2) - 1);
//        int end = pageNum == 0 ? (((pageNum + 1) * 2) - 1) : ((pageNum * 2) - 1);
//
//        for (int i = start; i <= end; i++) {
//            blogs.add(allBlog.get(i));
//            System.out.println(allBlog.get(i));
//        }
        return iBlogRepository.getBlogsByPageNum(limit);
    }

}
