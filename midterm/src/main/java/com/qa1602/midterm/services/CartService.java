package com.qa1602.midterm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa1602.midterm.model.Cart;
import com.qa1602.midterm.repository.CartRepositiory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
    @Autowired
    CartRepositiory cartRepositiory;

    public void addProduct(Cart cart) {
        cartRepositiory.save(cart);
    }
    
}
