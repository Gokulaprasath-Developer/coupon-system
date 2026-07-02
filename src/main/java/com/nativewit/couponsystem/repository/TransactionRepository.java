package com.nativewit.couponsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nativewit.couponsystem.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	boolean existsByUserIdAndCouponCode(int userId, String couponCode);

}