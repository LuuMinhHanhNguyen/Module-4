package com.example.blog1.service;

import com.example.blog1.model.Blog;
import com.example.blog1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {

        return iBlogRepository.findByFlagDeleteFalse(pageable);
    }

    @Override
    public void save(Blog newBlog) {
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
    public Page<Blog> findBlogsByCategory_IdAndFlagDeleteFalse(Integer categoryId, Pageable pageable) {
        return iBlogRepository.findBlogsByCategory_IdAndFlagDeleteFalse(categoryId, pageable);
    }

}
