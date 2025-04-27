/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.model;

import com.cw.enums.OrderStatus;

/**
 *
 * @author VimukthiWaththegama
 */
public class Order {

    private Long orderId;
    private Long customerId;
    private OrderStatus orderStatus;
    private double totalPrice;

    Order() {
    }

    Order(Long orderId, Long customerId, OrderStatus orderStatus, double totalPrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public OrderStatus getOrderstatus() {
        return orderStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
