package com.onlineshop.controller;

import com.onlineshop.domain.Product;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.dto.ProductDetailsDTO;
import com.onlineshop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Iterable<ProductDTO> getAll(){
        return productService.getAll();
    }

    @GetMapping("/products/details")
    public Iterable<ProductDetailsDTO> getProductsDetails(){
        return productService.getProductDetails();
    }

}
