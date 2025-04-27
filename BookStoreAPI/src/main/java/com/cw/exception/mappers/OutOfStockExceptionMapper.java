/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.exception.mappers;

import com.cw.exception.OutOfStockException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author VimukthiWaththegama
 */
public class OutOfStockExceptionMapper implements ExceptionMapper<OutOfStockException> {

    @Override
    public Response toResponse(OutOfStockException exception) {
        return Response.status(Response.Status.CONFLICT).
                entity(exception.getMessage()).
                build();
    }

}
