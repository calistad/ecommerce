package com.spring.backend.services;

import com.spring.backend.entities.Cart;
import com.spring.backend.entities.CartItem;
import com.spring.backend.entities.Customer;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
public class Purchase {
    @NonNull
    private Customer customer;

    @NonNull
    private Cart cart;

    @NonNull
    private Set<CartItem> cartItems;
}
