/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.dao;

import com.cw.model.Cart;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ws.rs.core.Response;

/**
 *
 * @author VimukthiWaththegama
 */
public class CartDAO {

    //ArrayList for store carts
    private static final List<Cart> cartList = new ArrayList<>();

    //Return all carts in the list
    public List<Cart> getAllCarts() {
        return cartList;
    }

    //For validation part with the Customer 
    private final CustomerDAO customerDAO = new CustomerDAO();

    //Return cart by id
    public Response getCartById(Long id) {
        try {
            if (id == null) {
                return Response.status(Response.Status.NOT_FOUND).
                        entity("CArt Id is null!").
                        build();
            }
            for (Cart cart : cartList) {
                if (id == cart.getCartId()) {
                    return Response.ok(cart).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Cart not found " + id).
                    build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error getting Cart by ID: " + e.getMessage())
                    .build();
        }
    }

    //Add cart to the list
    public Response createCart(Cart cart) {
        try {
            if (cart == null) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Cart is null!").
                        build();
            }
            for (Cart existingCart : cartList) {
                if (cart.getCartId() == existingCart.getCartId()) {
                    return Response.status(Response.Status.BAD_REQUEST).
                            entity("Cart already exists! " + cart.getCartId()).
                            build();
                }
            }
            if (!Objects.equals(cart.getCustomerId(), customerDAO.getCustomerById(cart.getCartId()))) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Customer does not exist! " + cart.getCartId()).
                        build();
            }
            cartList.add(cart);
            return Response.status(Response.Status.CREATED).
                    entity("Cart created! " + cart.getCartId()).
                    build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating Cart: " + e.getMessage())
                    .build();
        }
    }

    //Update existing carts
    public Response updateCart(Cart cart) {
        try {
            if (cart == null) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Cart is null!").
                        build();
            }
            for (Cart existingCart : cartList) {
                if (cart.getCartId() == existingCart.getCartId()) {
                    if (cart.getCartId() != null) {
                        return Response.status(Response.Status.CONFLICT)
                                .entity("You can only change the book list,total price and status!").build();
                    }
                    if (cart.getCustomerId() != null) {
                        return Response.status(Response.Status.CONFLICT)
                                .entity("You can only change the book list,total price and status!").build();
                    }
                    if (cart.getBooks() != null) {
                        existingCart.setBooks(cart.getBooks());
                    }
                    if (cart.getTotalPrice() > 0) {
                        existingCart.setTotalPrice(cart.getTotalPrice());
                    }
                    if (cart.getStatus() != null) {
                        existingCart.setStatus(cart.getStatus());
                    }
                    return Response.status(Response.Status.CREATED).
                            entity("Cart updated! " + cart.getCartId()).
                            build();
                }
            }
            if (!Objects.equals(cart.getCustomerId(), customerDAO.getCustomerById(cart.getCartId()))) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity("Customer does not exist! " + cart.getCartId()).
                        build();
            }
            cartList.add(cart);
            return Response.status(Response.Status.CREATED).
                    entity("Cart created! " + cart.getCartId()).
                    build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating Cart: " + e.getMessage())
                    .build();
        }
    }

    //Delete cart from the Cart List
    public Response deleteCart(Long id) {
        try {
            if (id == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Cart ID cannot be null!").build();
            }

            cartList.remove(getCartById(id));

            return Response.status(Response.Status.OK)
                    .entity("Customer deleted successfully! " + id)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting Cart: " + e.getMessage())
                    .build();
        }
    }
}
