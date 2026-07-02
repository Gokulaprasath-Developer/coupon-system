package com.nativewit.couponsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nativewit.couponsystem.dto.CouponRequest;
import com.nativewit.couponsystem.dto.CouponResponse;
import com.nativewit.couponsystem.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/validate-coupon")
    public CouponResponse validateCoupon(@RequestBody CouponRequest request) {
        return userService.validateCoupon(request);
    }

    @PostMapping("/apply-coupon")
    public CouponResponse applyCoupon(@RequestBody CouponRequest request) {
        return userService.applyCoupon(request);
    }

}