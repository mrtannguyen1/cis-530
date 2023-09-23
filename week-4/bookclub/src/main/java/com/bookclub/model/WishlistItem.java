/*
Krasso, R., (2021). CIS 530 Sever-Side Development. Bellevue University, all
rights reserved. 
Additional modifications by Nguyen, T.(2023) 
*/
package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WishlistItem {
	// Define an ISBN property with validation annotations
    @NotNull
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;
    // Define a title property with validation annotations
    @NotNull
    @NotEmpty(message = "Title is a required field.")
    private String title;
    // Default constructor (no arguments)
    public WishlistItem() {}

    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
    // Setter method for isbn
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    // Getter method for isbn
    public String getIsbn() {
        return isbn;
    }
    // Setter method for title
    public void setTitle(String title) {
        this.title = title;
    }
    // Getter method for title
    public String getTitle() {
        return title;
    }
 // Override toString() method to provide a custom string representation of the object
    @Override
    public String toString() {
        return String.format("WishlistItem{isbn=%s, title=%s}", isbn, title);
    }
} //End WishlistItem
