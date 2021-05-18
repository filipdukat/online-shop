package com.onlineshop.service;

import com.onlineshop.domain.Basket;
import com.onlineshop.domain.Coupon;
import com.onlineshop.domain.Product;
import com.onlineshop.dto.BasketDTO;
import com.onlineshop.repository.BasketRepository;
import com.onlineshop.repository.CouponRepository;
import com.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BasketService {
    private BasketRepository basketRepository;
    private ProductRepository productRepository;
    private CouponRepository couponRepository;

    public BasketService(BasketRepository basketRepository, ProductRepository productRepository, CouponRepository couponRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
        this.couponRepository = couponRepository;
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
                        .coupon(basket.getCoupon().toDTO())
                        .price(basket.getPrice().doubleValue())
                        .priceAfterDiscount(basket.getPriceAfterDiscount().doubleValue())
                        .build())
                .orElseThrow(); // zwroc BasketDTO lub wyjatek

    }

    public void add(int basketId, int productId, int quantity){
        Basket basket = basketRepository.findById(basketId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        basket.addProduct(product, quantity);
        basketRepository.save(basket);
    }

    public void useCouponCode(int basketId, String couponId){
        Basket basket = basketRepository.findById(basketId).orElseThrow();
        Coupon coupon = couponRepository.findById(couponId).orElseThrow();
        basket.setCoupon(coupon);
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
