package com.onlineshop.controller;

import com.onlineshop.domain.Basket;
import com.onlineshop.dto.BasketDTO;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class BasketController {
    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/basket/{id}")
    public ResponseEntity<BasketDTO> getBasket(@PathVariable int id){
        try {
            return ResponseEntity.ok(basketService.getBasket(id));
        }catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
            //return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/basket/{basketId}/product/{productId}")
    public void addProductToBasket(@PathVariable int basketId, @PathVariable int productId){
        basketService.add(basketId,productId);
    }
}
