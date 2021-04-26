package com.onlineshop.domain;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Coupon {
    @Id
    private String id;
    private double discount;
    private LocalDate startDate;
    private int discountDurationInDays;

    @PersistenceConstructor
    public Coupon() {
    }

    public Coupon(String id, double discount, LocalDate startDate, int discountDurationInDays) {
        this.id = id;
        this.discount = discount;
        this.startDate = startDate;
        this.discountDurationInDays = discountDurationInDays;
    }

    public String getId() {
        return id;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getDiscountDurationInDays() {
        return discountDurationInDays;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id='" + id + '\'' +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", discountDurationInDays=" + discountDurationInDays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Double.compare(coupon.discount, discount) == 0 &&
                discountDurationInDays == coupon.discountDurationInDays &&
                id.equals(coupon.id) &&
                startDate.equals(coupon.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount, startDate, discountDurationInDays);
    }
}
