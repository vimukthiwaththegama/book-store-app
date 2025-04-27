/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.resource;

import com.cw.dao.CustomerDAO;
import com.cw.exception.CustomerNotFoundException;
import com.cw.model.Customer;
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
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private final CustomerDAO customerDAO = new CustomerDAO();

    @GET
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCutstomers();
    }

    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") Long id) {
        Response customer =  customerDAO.getCustomerById(id);
        if(customer == null){
        throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        return customer;
    }

    @POST
    public Response createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }

    @PUT
    public Response updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @DELETE
    public Response deleteCustomer(@PathParam("id") Long id) {
        return customerDAO.deleteCustomer(id);
    }
}
