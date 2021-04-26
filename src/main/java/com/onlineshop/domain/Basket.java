package com.onlineshop.domain;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@Entity
public class Basket {
    @Id
    @GeneratedValue
    private int id;
    @ElementCollection
    private Map<Product, Integer> products;
    private String couponCode;

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

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
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

    public double getPrice(){
        BigDecimal price = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            price = price.add(product.getPrice().multiply(BigDecimal.valueOf(products.get(product))));
        }
        return price.doubleValue();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", products=" + products +
                ", couponCode='" + couponCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id &&
                products.equals(basket.products) &&
                couponCode.equals(basket.couponCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, couponCode);
    }
}
