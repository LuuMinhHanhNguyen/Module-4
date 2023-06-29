package com.example.ex1.service;

import com.example.ex1.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
}
