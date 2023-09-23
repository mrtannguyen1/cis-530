/*
Krasso, R., (2021). CIS 530 Sever-Side Development. Bellevue University, all
rights reserved. 
Additional modifications by Nguyen, T.(2023) 
*/
package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {
    List<WishlistItem> wishlist;
 // Constructor initializes the wishlist with some default items
    public MemWishlistDao() {
        this.wishlist = new ArrayList<WishlistItem>();
        this.wishlist.add(new WishlistItem("9780345339683", "The Hobbit or There and Back Again"));
        this.wishlist.add(new WishlistItem("9780261103573", "The Fellowship of the Ring"));
        this.wishlist.add(new WishlistItem("9780261102361", "The Two Towers"));
        this.wishlist.add(new WishlistItem("9780261102378", "The Return of the King"));
    }

    @Override
    public List<WishlistItem> list() {
        return this.wishlist;// Return the list of WishlistItems
    }

    @Override
    public WishlistItem find(String key) 
 // Iterate through the wishlist
    {
        for (WishlistItem item : wishlist)
        	// If the ISBN of the item matches the provided key, return the item
        {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
     // If no matching item is found, return a new, empty WishlistItem
        return new WishlistItem();
    }
} //End MemWishlistDao class
