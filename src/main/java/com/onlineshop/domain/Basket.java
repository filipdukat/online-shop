package com.onlineshop.domain;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;
import java.util.Objects;

@Entity
public class Basket {
    @Id
    @GeneratedValue
    private int id;
    @ElementCollection
    private Map<Product, Integer> products;

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

    public void addProduct(Product product){
        products.put(product,1);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id &&
                products.equals(basket.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }
}
