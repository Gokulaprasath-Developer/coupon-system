package com.nativewit.couponsystem.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.stereotype.Service;

import com.nativewit.couponsystem.dto.CouponRequest;
import com.nativewit.couponsystem.dto.CouponResponse;
import com.nativewit.couponsystem.entity.Coupon;
import com.nativewit.couponsystem.entity.Transaction;
import com.nativewit.couponsystem.repository.CouponRepository;
import com.nativewit.couponsystem.repository.TransactionRepository;

@Service
public class UserService {

	@Autowired
    private CouponRepository couponRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    
    public CouponResponse validateCoupon(CouponRequest request) {

        Coupon coupon = couponRepository.findByCouponCode(request.getCouponCode());

        if (coupon == null) {
            return new CouponResponse(false, "Coupon not found", request.getAmount());
        }

        if (!coupon.isActive()) {
            return new CouponResponse(false, "Coupon is inactive", request.getAmount());
        }

        boolean alreadyUsed = transactionRepository.existsByUserIdAndCouponCode(
                request.getUserId(),
                request.getCouponCode());

        if (alreadyUsed) {
            return new CouponResponse(false, "Coupon already used", request.getAmount());
        }

        return new CouponResponse(true, "Coupon is valid", 0);

    }
    
    @Transactional
    public CouponResponse applyCoupon(CouponRequest request) {

        Coupon coupon = couponRepository.findByCouponCode(request.getCouponCode());

        if (coupon == null) {
            return new CouponResponse(false, "Coupon not found", request.getAmount());
        }

        if (!coupon.isActive()) {
            return new CouponResponse(false, "Coupon is inactive", request.getAmount());
        }

        boolean alreadyUsed = transactionRepository.existsByUserIdAndCouponCode(
                request.getUserId(),
                request.getCouponCode());

        if (alreadyUsed) {
            return new CouponResponse(false, "Coupon already used", request.getAmount());
        }

        double discountedAmount = request.getAmount() * 0;

        Transaction transaction = new Transaction();

        transaction.setUserId(request.getUserId());
        transaction.setCouponCode(request.getCouponCode());
        transaction.setOriginalAmount(request.getAmount());
        transaction.setDiscountedAmount(discountedAmount);

        try {
            transactionRepository.save(transaction);
        } catch (DataIntegrityViolationException e) {
            return new CouponResponse(
                false,
                "Coupon already used",
                request.getAmount()
            );
        }

        return new CouponResponse(true, "Coupon applied successfully", discountedAmount);
    }
}
