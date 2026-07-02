package com.nativewit.couponsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nativewit.couponsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}