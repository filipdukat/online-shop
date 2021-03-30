package com.onlineshop.dto;

import com.onlineshop.domain.Product;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BasketDTO {
    private int id;
    private Map<Product, Integer> products;


}
