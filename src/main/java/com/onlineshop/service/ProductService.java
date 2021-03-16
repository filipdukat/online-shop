package com.onlineshop.service;

import com.onlineshop.domain.Product;
import com.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void addDefaultProduct(){
        if (productRepository.count()>0){
            return;
        }

        Product product1 = new Product("watch");
        Product product2 = new Product("phone");

        productRepository.save(product1);
        productRepository.save(product2);
    }
}
