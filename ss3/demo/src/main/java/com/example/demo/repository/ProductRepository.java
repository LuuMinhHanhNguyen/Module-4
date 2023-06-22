package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "iPhone", 1111, "This is an iPhone!", "Apple"));
        products.add(new Product(2, "iPad", 777, "This is an iPad!", "Apple"));
        products.add(new Product(3, "Macbook", 1111, "This is a macbook!", "Apple"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void createProduct(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
    }

    @Override
    public void deleteProduct(int productId) {
        Product deletedProduct = this.getProductById(productId);
        products.remove(deletedProduct);
    }

    @Override
    public Product getProductById(int productId) {
        return this.getAll().stream().filter(p -> p.getId().equals(productId)).findFirst().get();
    }

    @Override
    public void editProduct(Product product) {
        Product editedProduct = this.getProductById(product.getId());
        int index = this.getAll().indexOf(editedProduct);
        products.set(index, product);
    }

    @Override
    public List<Product> searchByName(String productName) {
        List<Product> searchedProducts = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().toLowerCase().contains(productName)){
                searchedProducts.add(products.get(i));
            }
        }
        return searchedProducts;
    }

    @Override
    public boolean checkExistence(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == productId){
                return true;
            }
        }
        return false;
    }


}
