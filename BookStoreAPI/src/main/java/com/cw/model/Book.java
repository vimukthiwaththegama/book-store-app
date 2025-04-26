/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.model;

import java.util.Date;

/**
 *
 * @author VimukthiWaththegama
 */
public class Book {

    private Long bookId;
    private String bookName;
    private Long authorId;
    private String isbn;
    private Date publicYear;
    private double price;
    private int quantity;

    Book(){
    }

    Book(Long bookId, String bookName, Long authorId, String isbn, Date publicYear, double price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorId = authorId;
        this.isbn = isbn;
        this.publicYear = publicYear;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getPublicYear() {
        return publicYear;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicYear(Date publicYear) {
        this.publicYear = publicYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
