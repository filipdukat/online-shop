package com.onlineshop.service;

import com.onlineshop.domain.Basket;
import com.onlineshop.domain.Product;
import com.onlineshop.dto.BasketDTO;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.repository.BasketRepository;
import com.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasketService {
    private BasketRepository basketRepository;
    private ProductRepository productRepository;

    public BasketService(BasketRepository basketRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void createDefaultBasket(){
        Basket basket1 = new Basket();
        Basket basket2 = new Basket();

        basketRepository.save(basket1);
        basketRepository.save(basket2);
    }

    public BasketDTO getBasket(int id) {
        return basketRepository.findById(id)  // Optional<Basket>
                .map(basket -> BasketDTO.builder()  // Optional<BasketDTO>
                        .id(basket.getId())
                        .products(basket.getProducts())
                        .build())
                .orElseThrow(); // zwroc BasketDTO lub wyjetek

    }

    public void add(int basketId, int productId){
        Basket basket = basketRepository.findById(basketId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        basket.addProduct(product);
        basketRepository.save(basket);
    }

    /*public BasketDTO getBasketV2(int id) {
        Basket basket = basketRepository.findById(id).orElseThrow();
        BasketDTO basketDTO = BasketDTO.builder()
                .id(basket.getId())
                .products(basket.getProducts())
                .build();
        return basketDTO;
    }*/

}
