/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.resource;

import com.cw.dao.CartDAO;
import com.cw.exception.CartNotFoundException;
import com.cw.model.Cart;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author VimukthiWaththegama
 */
@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
    
    private final CartDAO cartDAO = new CartDAO();
    
    @GET
    public List<Cart> getAllCarts() {
        return cartDAO.getAllCarts();
    }
    
    @GET
    @Path("/{id}")
    public Response getCartById(@PathParam("id") Long id) {
        Response cart = cartDAO.getCartById(id);
        if(cart == null){
        throw new CartNotFoundException("Cart with ID " + id + " not found");
        }
        return cart;
    }
    
    @POST
    public Response createCart(Cart cart) {
        return cartDAO.createCart(cart);
    }
    
    @PUT
    public Response updateCart(Cart cart) {
        return cartDAO.updateCart(cart);
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteCart(@PathParam("id") Long id) {
        return cartDAO.deleteCart(id);
    }
}
