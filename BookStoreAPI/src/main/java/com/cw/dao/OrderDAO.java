/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.dao;

import com.cw.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author VimukthiWaththegama
 */
public class OrderDAO {

    //ArrayList for maintain Orders
    private static final List<Order> orderList = new ArrayList<>();

    //Return all orders
    public List<Order> getAllOrders() {
        return orderList;
    }

    //For validate with Customer model
    private final CustomerDAO customerDAO = new CustomerDAO();

    //Return order by ID
    public Response getOrderById(Long id) {
        try {
            if (id == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Order Id is null! ")
                        .build();
            }

            for (Order order : orderList) {
                if (order.getOrderId() == id) {
                    return Response.ok(order).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Order not found!")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error getting Order by ID: " + e.getMessage())
                    .build();
        }
    }

    //Create new order
    public Response createOrder(Order order) {
        try {
            if (order == null) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Order is null").
                        build();

            }
            for (Order existingOrder : orderList) {
                if (existingOrder.getOrderId() == order.getOrderId()) {
                    return Response.status(Response.Status.BAD_REQUEST).
                            entity("Order already exists!").
                            build();
                }
            }
            if (customerDAO.getCustomerById(order.getCustomerId()) == null) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Customer ID does not exists!").
                        build();
            }

            orderList.add(order);
            return Response.status(Response.Status.CREATED).
                    entity("Order successfully created! " + order.getOrderId())
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating Order :" + e.getMessage())
                    .build();
        }
    }

    
    //Update existing orders
    public Response updateOrder(Order order) {
        try {
            if (order == null) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Order is null").
                        build();
            }
            for (Order existingOrder : orderList) {
                if (existingOrder.getOrderId() == order.getOrderId()) {
                    if (order.getOrderId() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the total price and status!").
                                build();
                    }
                    if (order.getCustomerId() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the total price and status!").
                                build();
                    }
                    if (order.getTotalPrice() > 0) {
                        existingOrder.setTotalPrice(order.getTotalPrice());
                    }
                    if (order.getOrderstatus()!= null) {
                       existingOrder.setOrderStatus(order.getOrderstatus());
                    }
                    return Response.status(Response.Status.CREATED).
                            entity("Order updated successfully! " + order.getOrderId()).
                            build();
                }
            }
            if (customerDAO.getCustomerById(order.getCustomerId()) == null) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Customer ID does not exists!").
                        build();
            }

            orderList.add(order);
            return Response.status(Response.Status.CREATED).
                    entity("Order successfully created! " + order.getOrderId())
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating Order :" + e.getMessage())
                    .build();
        }
    }
    
    //Delete orders
    public Response deleteOrder(Long id){
    try{
    if(id == null){
    return Response.status(Response.Status.NOT_FOUND)
                        .entity("Order Id is null! ")
                        .build();
    }
    if(getOrderById(id) == null){
    return Response.status(Response.Status.NOT_FOUND)
                        .entity("Invalid order ID! ")
                        .build();
    }
    orderList.remove(getOrderById(id));
    return Response.status(Response.Status.CREATED)
                        .entity("Order deleted successfully! "+id)
                        .build();
    }
    catch(Exception e){
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting Order :" + e.getMessage())
                    .build();
    }
    }
}
