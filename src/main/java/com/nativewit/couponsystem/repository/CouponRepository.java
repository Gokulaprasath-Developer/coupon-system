package com.nativewit.couponsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nativewit.couponsystem.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    Coupon findByCouponCode(String couponCode);

}
