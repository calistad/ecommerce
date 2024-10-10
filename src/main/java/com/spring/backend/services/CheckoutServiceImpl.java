package com.spring.backend.services;

import com.spring.backend.dao.CartItemRepository;
import com.spring.backend.dao.CartRepository;
import com.spring.backend.entities.Cart;
import com.spring.backend.entities.CartItem;
import com.spring.backend.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // Retrieve order info
        Cart cart = purchase.getCart();

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // Set cart status
        cart.setStatus(StatusType.ORDERED);

        // Save to database
        cartRepository.save(cart);

        // Return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    // Create a random complex unique id
    private String generateOrderTrackingNumber() {
        // Generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
