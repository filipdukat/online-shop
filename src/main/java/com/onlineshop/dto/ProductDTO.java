package com.onlineshop.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDTO {
    private int id;
    private String name;
    private BigDecimal price;
    private String imageURL;
}
