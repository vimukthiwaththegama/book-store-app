/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.dao;

import com.cw.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author VimukthiWaththegama
 */
public class CustomerDAO {

    //ArrayList for storing Customer Objects
    private static List<Customer> customerList = new ArrayList<>();

    //Return all customers
    public List<Customer> getAllCutstomers() {
        return customerList;
    }

    //Return customer by Id
    public Response getCustomerById(Long id) {
        try {
            for (Customer customer : customerList) {
                if (customer.getCustomerId() == id) {
                    return Response.ok(customer).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Customer not found!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error getting Customers: " + e.getMessage())
                    .build();
        }
    }

    //Create new customer
    public Response createCustomer(Customer customer) {
        try {
            if (customer == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Customer cannot be null!").build();
            }

            for (Customer existingCustomer : customerList) {
                if (customer.getCustomerId() == existingCustomer.getCustomerId()) {
                    return Response.status(Response.Status.CONFLICT)
                            .entity("Customer already exists!").build();
                }
            }

            customerList.add(customer);
            return Response.status(Response.Status.CREATED)
                    .entity("Customer created successfully! " + customer.getClass()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating Customers: " + e.getMessage())
                    .build();
        }
    }

    //Update existing customer
    public Response updateCustomer(Customer customer) {
        try {
            if (customer == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Customer cannot be null!").build();
            }
            for (Customer existingCustomer : customerList) {
                if (customer.getCustomerId() == existingCustomer.getCustomerId()) {
                    if (customer.getCustomerId() != null) {
                        return Response.status(Response.Status.CONFLICT)
                                .entity("You can only change the customer name and email!").build();
                    }
                    if (customer.getCustomerName() != null) {
                        existingCustomer.setCustomerName(customer.getCustomerName());
                    }
                    if (customer.getEmail() != null) {
                        existingCustomer.setEmail(customer.getEmail());
                    }
                    return Response.status(Response.Status.OK)
                            .entity("Customer updated successfully! ID: " + existingCustomer.getCustomerId())
                            .build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Customer not found!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating Customer: " + e.getMessage())
                    .build();
        }
    }

    //Delete customer by ID
    public Response deleteCustomer(Long customerId) {
        try {
            if (customerId == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Customer cannot be null!").build();
            }

            if (getCustomerById(customerId) == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Customernot found with ID: " + customerId)
                        .build();
            }
            customerList.remove(getCustomerById(customerId));

            return Response.status(Response.Status.OK)
                    .entity("Book deleted successfully! " + customerId)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deletin Customer: " + e.getMessage())
                    .build();
        }
    }
}
