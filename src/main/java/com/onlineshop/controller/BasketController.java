package com.onlineshop.controller;

import com.onlineshop.domain.Basket;
import com.onlineshop.dto.BasketDTO;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<?> addProductToBasket(@PathVariable int basketId, @PathVariable int productId, @RequestParam(defaultValue = "1") int quantity){
        try{
            basketService.add(basketId,productId, quantity);
            return ResponseEntity.ok("Product added");
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Can not add product.");
        }
    }

    @PostMapping("/basket/{basketId}/coupon/{couponId}")
    public ResponseEntity<?> useCouponCode(@PathVariable int basketId, @PathVariable String couponId){
        basketService.useCouponCode(basketId,couponId);
        return ResponseEntity.ok("Coupon applied successfully.");
    }
}
