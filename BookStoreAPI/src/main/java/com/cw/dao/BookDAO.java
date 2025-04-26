/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.dao;

import com.cw.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author VimukthiWaththegama
 */
public class BookDAO {

    //Store books in a Array list
    public static List<Book> bookList = new ArrayList<>();

    //For validation part with AuthorDAO
    private final AuthorDAO authorDAO = new AuthorDAO();

    //Return book by Id
    public Response getBookById(Long id) {
        try {
            for (Book book : bookList) {
                if (id == book.getBookId()) {
                    return Response.ok(book).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Book not found! " + id).
                    build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error getting book by ID: " + e.getMessage())
                    .build();
        }
    }

    //Retun all books
    public List<Book> getAllBooks() {
        return bookList;
    }

    //Adding new book to the list,*check author is available
    public Response createBook(Book book) {
        try {
            if (book == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Book cannot be null")
                        .build();
            }

            Response authorResponse = authorDAO.getAuthorById(book.getAuthorId());
            if (authorResponse.getStatus() != Response.Status.OK.getStatusCode()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Book does not exist")
                        .build();
            }

            for (Book existingBook : bookList) {
                if (existingBook.getBookId().equals(book.getBookId())) {
                    return Response.status(Response.Status.CONFLICT)
                            .entity("Book already exists! " + book.getBookId())
                            .build();
                }
            }

            bookList.add(book);
            return Response.status(Response.Status.CREATED)
                    .entity("Book created Successfully " + book.getBookId())
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating Book: " + e.getMessage())
                    .build();
        }
    }

    //Update existing book in the list
    public Response updateBook(Book book) {
        try {
            Response authorResponse = authorDAO.getAuthorById(book.getAuthorId());
            if (authorResponse.getStatus() != Response.Status.OK.getStatusCode()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Book does not exist")
                        .build();
            }

            for (Book existingBook : bookList) {
                if (existingBook.getBookId().equals(book.getBookId())) {
                    if (book.getBookId() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the price and quantity!").build();
                    }
                    if (book.getAuthorId() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the price and quantity!").build();
                    }
                    if (book.getBookName() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the price and quantity!").build();
                    }
                    if (book.getIsbn() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the price and quantity!").build();
                    }
                    if (book.getPublicYear() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the price and quantity!").build();
                    }
                    if (book.getAuthorId() != null) {
                        return Response.status(Response.Status.CONFLICT).
                                entity("You can only change the price and quantity!").build();
                    }
                    if (book.getPrice() >= 0) {
                        existingBook.setPrice(book.getPrice());
                    }
                    if (book.getQuantity() > 0) {
                        existingBook.setQuantity(book.getQuantity());
                    }
                    return Response.status(Response.Status.CREATED)
                            .entity("Book updated successfully!! " + book.getBookId())
                            .build();
                }
            }
            return Response.status(Response.Status.CONFLICT)
                    .entity("Nothing to update!")
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating Book: " + e.getMessage())
                    .build();
        }
    }

    //Remove from the list by Id
    public Response deleteBook(Long id) {
        try {
            if (id == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Book ID cannot be null")
                        .build();
            }

            getBookById(id);

            if (getBookById(id) == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Book not found with ID: " + id)
                        .build();
            }

            bookList.remove(getBookById(id));

            return Response.status(Response.Status.OK)
                    .entity("Book deleted successfully! " + id)
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting book: " + e.getMessage())
                    .build();
        }
    }
}
