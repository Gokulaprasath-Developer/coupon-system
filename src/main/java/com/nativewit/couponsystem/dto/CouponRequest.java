package com.nativewit.couponsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequest {

    private int userId;

    private String couponCode;

    private double amount;
    
    public int getUserId() {
        return userId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public double getAmount() {
        return amount;
    }
}