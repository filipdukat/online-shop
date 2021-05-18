package com.onlineshop.domain;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue
    private int id;
    @ElementCollection
    private Map<Product, Integer> products;
    @ManyToOne
    private Coupon coupon;

    @PersistenceConstructor
    public Basket() {
    }

    public Basket(Map<Product, Integer> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void addProduct(Product product, int quantity){

        if(quantity<=0){
            throw new IllegalArgumentException("Quantity should be greater than 0.");
        }

        if(products.containsKey(product)){
            products.put(product,quantity + products.get(product));
        }else{
            products.put(product,quantity);
        }
    }

    public BigDecimal getPrice(){
        BigDecimal price = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            price = price.add(product.getPrice().multiply(BigDecimal.valueOf(products.get(product))));
        }
        return price;
    }

    public BigDecimal getPriceAfterDiscount(){
        BigDecimal price = getPrice();

        return coupon.applyCoupon(price);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", products=" + products +
                ", coupon=" + coupon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id &&
                Objects.equals(products, basket.products) &&
                Objects.equals(coupon, basket.coupon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, coupon);
    }
}
