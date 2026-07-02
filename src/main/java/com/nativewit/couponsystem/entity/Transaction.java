package com.nativewit.couponsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"userId", "couponCode"})
		})

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private String couponCode;

    private double originalAmount;

    private double discountedAmount;
    
    //manual setter(lombok not working)
    
    public void setUserId(int userId) {

        this.userId = userId;

    }

    public void setCouponCode(String couponCode) {

        this.couponCode = couponCode;

    }

    public void setOriginalAmount(double originalAmount) {

        this.originalAmount = originalAmount;

    }

    public void setDiscountedAmount(double discountedAmount) {

        this.discountedAmount = discountedAmount;

    }

}