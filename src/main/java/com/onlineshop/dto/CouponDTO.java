package com.onlineshop.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class CouponDTO {
    private String id;
    private double discount;
    private LocalDate startDate;
    private int discountDurationInDays;
    private LocalDate endDate;
}
