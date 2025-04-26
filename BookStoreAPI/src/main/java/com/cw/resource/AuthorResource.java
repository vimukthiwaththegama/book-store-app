/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.resource;

import com.cw.dao.AuthorDAO;
import com.cw.model.Author;
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
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    private final AuthorDAO authorDAO = new AuthorDAO();

    @GET
    public List<Author> getAllAuthors() {
        List<Author> allAuthors = authorDAO.getAllAuthors();
        return allAuthors;
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") Long id) {
        return authorDAO.getAuthorById(id);
    }

    @POST
    public Response createAuthor(Author author) {
        return authorDAO.createAuthor(author);
    }

    @PUT
    public Response updateAuthor(Author author) {
        return authorDAO.updateAuthor(author);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") Long id) {
        return authorDAO.deleteAuthor(id);
    }
}
