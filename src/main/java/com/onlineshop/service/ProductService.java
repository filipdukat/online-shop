package com.onlineshop.service;

import com.onlineshop.domain.Product;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.dto.ProductDetailsDTO;
import com.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

        Product product1 = new Product("watch"
                , BigDecimal.valueOf(50.99)
                , "https://metrocool.co.nz/wp-content/uploads/2016/02/watch-img.png"
                , List.of("Automatic", "Waterproof")
                , 9.5
                , "I like this watch.");
        Product product2 = new Product("phone"
                , BigDecimal.valueOf(1000.99)
                , "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=800&q=80"
                , List.of("LCD display", "Waterproof")
                , 8.9
                ,"Good phone.");

        productRepository.save(product1);
        productRepository.save(product2);
    }

    public Iterable<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();

        for (Product product : products) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .imageURL(product.getImageURL())
                    .build();

            productsDTO.add(productDTO);
        }

        return productsDTO;
    }

    public Iterable<ProductDetailsDTO> getProductDetails(){
        List<Product> products = productRepository.findAll();
        List<ProductDetailsDTO> productsDetailsDTO = new ArrayList<>();

        for (Product product : products) {
            ProductDetailsDTO productDetailsDTO = ProductDetailsDTO.builder()
                    .id(product.getId())
                    .attributes(product.getAttributes())
                    .rating(product.getRating())
                    .review(product.getReview())
                    .build();

            productsDetailsDTO.add(productDetailsDTO);
        }

        return productsDetailsDTO;
    }
}
