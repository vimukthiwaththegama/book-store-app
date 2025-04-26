/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cw.model;

/**
 * @author VimukthiWaththegama
 */
public class Author {

    private Long authorID;
    private String name;
    private String biography;

    Author() {
    }

    Author(Long authorId, String name, String biography) {
        this.authorID = authorId;
        this.name = name;
        this.biography = biography;
    }

    public Long getAuthorId() {
        return authorID;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public void setAuthorId(Long authorId) {
        this.authorID = authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
