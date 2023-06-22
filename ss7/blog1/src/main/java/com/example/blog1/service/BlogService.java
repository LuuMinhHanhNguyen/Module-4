package com.example.blog1.service;

import com.example.blog1.model.Blog;
import com.example.blog1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iProductRepository;

    @Override
    public List<Blog> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Blog newBlog) {
        iProductRepository.save(newBlog);
    }

    @Override
    public Blog findById(Integer id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public boolean checkIDExistence(Integer id) {
        return iProductRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        iProductRepository.deleteById(id);
    }




//    @Override
//    public List<Product> getAll() {
//        return iProductRepository.getAll();
//    }
//
//    @Override
//    public void createProduct(Product product) {
//        iProductRepository.createProduct(product);
//    }
//
//    @Override
//    public void deleteProduct(int productId) {
//        iProductRepository.deleteProduct(productId);
//    }
//
//    @Override
//    public Product getProductById(int productId) {
//        return iProductRepository.getProductById(productId);
//    }
//
//    @Override
//    public void editProduct(Product product) {
//        iProductRepository.editProduct(product);
//    }
//
//    @Override
//    public List<Product> searchByName(String productName) {
//        return iProductRepository.searchByName(productName);
//    }
//
//    @Override
//    public boolean checkExistence(int productId) {
//        return iProductRepository.checkExistence(productId);
//    }
}
