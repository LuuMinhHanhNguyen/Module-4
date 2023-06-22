package com.example.blog1.repository;


import com.example.blog1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    List<Product> getAll();
//
//    void createProduct(Product product);
//    void deleteProduct(int productId);
//
//    Product getProductById(int productId);
//
//    void editProduct(Product product);
//
//    List<Product> searchByName(String productName);
//
//    boolean checkExistence(int productId);
}
