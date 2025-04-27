/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.exception;

/**
 *
 * @author VimukthiWaththegama
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
