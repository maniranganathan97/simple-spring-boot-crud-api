package com.product.api.service;

import com.product.api.model.Product;
import com.product.api.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product){
        return this.repository.save(product);
    }

    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public Optional<Product> getProductById(int productId) {
        return this.repository.findById(productId);
    }

    public void deleteByProductId(int productId) {
        this.repository.deleteById(productId);
    }
}
