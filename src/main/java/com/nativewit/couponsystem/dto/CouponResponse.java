package com.nativewit.couponsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CouponResponse {

    private boolean valid;
    private String message;
    private double discountedAmount;

    public CouponResponse(boolean valid, String message, double discountedAmount) {
        this.valid = valid;
        this.message = message;
        this.discountedAmount = discountedAmount;
    }
}