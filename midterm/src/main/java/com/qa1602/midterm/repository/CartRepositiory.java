package com.qa1602.midterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.qa1602.midterm.model.Cart;
@Component
public interface CartRepositiory extends JpaRepository<Cart, Long>{
    
}
