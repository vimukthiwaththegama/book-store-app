/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.resource;

import com.cw.dao.OrderDAO;
import com.cw.model.Order;
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
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private static final OrderDAO orderDAO = new OrderDAO();

    @GET
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @GET
    @Path("/{id}")
    public Response getOrderById(@PathParam("id") Long id) {
        return orderDAO.getOrderById(id);
    }

    @POST
    public Response createOrder(Order order) {
        return orderDAO.createOrder(order);
    }

    @PUT
    public Response updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") Long id) {
        return orderDAO.deleteOrder(id);
    }
}
