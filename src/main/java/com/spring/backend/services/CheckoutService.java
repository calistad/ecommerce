package com.spring.backend.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
