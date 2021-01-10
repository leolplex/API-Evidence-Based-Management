package com.ebm.domain.service;

import com.ebm.domain.Product;
import com.ebm.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProductById(int idProduct) {
        return productRepository.getProductById(idProduct);
    }

    public List<Product> getProductsByUserId(int idUser) {
        return productRepository.getProductsByUserId(idUser);
    }
}
