package com.onlineshop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDetailsDTO {
    private int id;
    private List<String> attributes;
    private double rating;
    private String review;

}
