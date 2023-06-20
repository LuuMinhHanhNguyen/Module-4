package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void createProduct(Product product);
    void deleteProduct(int productId);
    Product getProductById(int productId);
    void editProduct(Product product);
    List<Product> searchByName(String productName);
}
