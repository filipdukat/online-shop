package com.onlineshop.controller;

import com.onlineshop.dto.CouponDTO;
import com.onlineshop.service.CouponService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CouponController {
    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    private List<CouponDTO> getAllCoupons(){
        return null;

        //todo adding coupon
        //todo using coupon in basket
    }
}
