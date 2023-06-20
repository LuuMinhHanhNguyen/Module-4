package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.getAll();
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        iProductRepository.deleteProduct(productId);
    }

    @Override
    public Product getProductById(int productId) {
        return iProductRepository.getProductById(productId);
    }

    @Override
    public void editProduct(Product product) {
        iProductRepository.editProduct(product);
    }

    @Override
    public List<Product> searchByName(String productName) {
        return iProductRepository.searchByName(productName);
    }
}
