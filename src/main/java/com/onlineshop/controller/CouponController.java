package com.onlineshop.controller;

import com.onlineshop.dto.BasketDTO;
import com.onlineshop.dto.CouponDTO;
import com.onlineshop.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class CouponController {
    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    private List<CouponDTO> getAllCoupons(){
        return null;

        //todo using coupon in basket
    }

    @PostMapping("/api/coupons")
    public ResponseEntity<CouponDTO> addCoupon(@RequestBody CouponDTO couponDTO){
        CouponDTO result = couponService.addCoupon(couponDTO);
        return ResponseEntity.ok(result);
    }

    //todo pobierz wszystkie kupony - get mapping
    //todo skasuj wybrany kupon podajac jego id - delete mapping

}
