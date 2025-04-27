/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.exception.mappers;

import com.cw.exception.AuthorNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author VimukthiWaththegama
 */
public class AuthorNotFoundExceptionMapper implements ExceptionMapper<AuthorNotFoundException> {

    @Override
    public Response toResponse(AuthorNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .build();
    }
}
