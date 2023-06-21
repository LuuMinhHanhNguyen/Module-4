package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void createProduct(Product product);
    void deleteProduct(int productId);

    Product getProductById(int productId);

    void editProduct(Product product);

    List<Product> searchByName(String productName);

    boolean checkExistence(int productId);
}
