/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.model;

import com.cw.enums.CartStatus;
import java.util.List;

/**
 *
 * @author VimukthiWaththegama
 */
public class Cart {

    private Long cartId;
    private Long customerId;
    private List<Book> bookList;
    private double totalPrice;
    private CartStatus status;

    Cart() {
    }

    Cart(Long cartId, Long customerId, List<Book> bookList, double totalPrice, CartStatus status) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.bookList = bookList;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<Book> getBooks() {
        return bookList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setCardId(Long cardId) {
        this.cartId = cardId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setBooks(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }
}
