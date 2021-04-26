package com.onlineshop.domain;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private BigDecimal price;
    private String imageURL;
    @ElementCollection
    private List<String> attributes;
    private double rating;
    private String review;

    @PersistenceConstructor
    private Product() {
    }

    public Product(String name, BigDecimal price, String imageURL, List<String> attributes, double rating, String review) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.attributes = attributes;
        this.rating = rating;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                ", attributes=" + attributes +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
