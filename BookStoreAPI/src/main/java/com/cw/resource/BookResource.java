/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.resource;

import com.cw.dao.BookDAO;
import com.cw.exception.BookNotFoundException;
import com.cw.model.Book;
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
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    
    private final BookDAO bookDAO = new BookDAO();
    
    @GET
    public List<Book> getAllBooks() {
        List<Book> allBooks = bookDAO.getAllBooks();
        return allBooks;
    }
    
    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id) {
        Response book = bookDAO.getBookById(id);
        if(book == null){
        throw new BookNotFoundException("Book with ID " + id + " not found");
        }
        return book;
    }
    
    @POST
    public Response createBook(Book book) {
        return bookDAO.createBook(book);
    }
    
    @PUT
    public Response updateBook(Book book) {
        return bookDAO.updateBook(book);
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletBook(@PathParam("id") Long id) {
        return bookDAO.deleteBook(id);
    }
    
}
