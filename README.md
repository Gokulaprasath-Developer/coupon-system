# Coupon System

## Overview
A Spring Boot REST API for validating and applying coupons.

## Technologies
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

## Features
- Validate coupon
- Apply coupon
- Prevent duplicate coupon usage
- Transaction recording

## API Endpoints

### POST /validate-coupon

```json
{
  "userId": 1,
  "couponCode": "FREE100",
  "amount": 1000
}
```

### POST /apply-coupon

```json
{
  "userId": 1,
  "couponCode": "FREE100",
  "amount": 1000
}
```

## Business Logic

- Validate coupon
- Check expiry
- Check duplicate usage
- Calculate discount
- Save transaction
- Return response

## Author

Gokulaprasath
