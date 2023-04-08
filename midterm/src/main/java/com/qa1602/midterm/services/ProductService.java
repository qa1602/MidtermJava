package com.qa1602.midterm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa1602.midterm.model.Product;
import com.qa1602.midterm.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();   
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(new Product());
    }
}
