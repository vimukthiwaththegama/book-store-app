/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.dao;

import com.cw.model.Author;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author VimukthiWaththegama
 */
public class AuthorDAO {

    //Store Authors in a ArrayList
    private static List<Author> authorList = new ArrayList<>();
    
    //Return all authors in the in authorList
    public List<Author> getAllAuthors() {
        return authorList;
    }

    //Return author by it's Id
    public Response getAuthorById(Long authorId) {
        try {
            for (Author author : authorList) {
                if (authorId == author.getAuthorId()) {
                    return Response.ok(author).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Author not found!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error getting author: " + e.getMessage())
                    .build();
        }
    }

    //Adding a new author 
    public Response createAuthor(Author author) {
        try {
            if (author == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Author cannot be null!").build();
            }

            for (Author existingAuthor : authorList) {
                if (author.getAuthorId().equals(existingAuthor.getAuthorId())) {
                    return Response.status(Response.Status.CONFLICT)
                            .entity("Author already exists!").build();
                }
            }

            authorList.add(author);
            return Response.status(Response.Status.CREATED)
                    .entity("Author created successfully! "+author.getAuthorId()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding author: " + e.getMessage())
                    .build();
        }
    }

    //Update existing author
    public Response updateAuthor(Author author) {
        try {
            if (author == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Author Id is null!").build();
            }

            for (Author existingAuthor : authorList) {
                if (author.getAuthorId().equals(existingAuthor.getAuthorId())) {
                    if (author.getName() != null) {
                        existingAuthor.setName(author.getName());
                    }
                    if (author.getBiography() != null) {
                        existingAuthor.setBiography(author.getBiography());
                    }
                    if (author.getName() != null) {
                        existingAuthor.setName(author.getName());
                    }
                    return Response.status(Response.Status.CREATED)
                            .entity("Author updated successfully! "+existingAuthor.getAuthorId()).build();
                }
            }
            return Response.status(Response.Status.CREATED)
                    .entity("Nothing to change!").build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating author: " + e.getMessage())
                    .build();
        }
    }
    
    //Delete existing author
    public Response deleteAuthor(Long authorId) {
        try {
            for (Author existingAuthor : authorList) {
                if (authorId.equals(existingAuthor.getAuthorId())) {
                    authorList.remove(existingAuthor);
                    return Response.status(Response.Status.OK)
                            .entity("Author deleted successfully! " +authorId).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Author not found").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting author: " + e.getMessage())
                    .build();
        }
    }
}
