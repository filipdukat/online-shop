package com.onlineshop.service;

import com.onlineshop.domain.Coupon;
import com.onlineshop.dto.CouponDTO;
import com.onlineshop.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public CouponDTO addCoupon(CouponDTO couponDTO){
        Coupon coupon = new Coupon(couponDTO.getId(),
                couponDTO.getDiscount(),
                couponDTO.getStartDate(),
                couponDTO.getDiscountDurationInDays());
        couponRepository.save(coupon);
        return couponDTO;
    }
}
