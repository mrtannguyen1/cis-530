/*
Krasso, R., (2021). CIS 530 Sever-Side Development. Bellevue University, all
rights reserved. 
Additional modifications by Nguyen, T.(2023) 
*/
package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MemWishlistDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
	// This method handles GET requests to the root path ("/")
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model)
    // Create an instance of MemWishlistDao
    {
        MemWishlistDao wishlistDao = new MemWishlistDao();
     // Retrieve a list of WishlistItems from the DAO
        List<WishlistItem> wishlist = wishlistDao.list();
        // Add the list of WishlistItems to the model, so it can be accessed in the view
        model.addAttribute("wishlist", wishlist);
        // Return the name of the view to be rendered
        return "wishlist/list";
    }
 // This method handles GET requests to the "/new" path
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model)
    // Add a new, empty WishlistItem to the model
    {
        model.addAttribute("wishlistItem", new WishlistItem());
        // Return the name of the view to be rendered
        return "wishlist/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {
    	 // Print the string representation of the WishlistItem
    	System.out.println(wishlistItem.toString());
    	// Print any validation errors that occurred during the binding process
        System.out.println(bindingResult.getAllErrors());
     // If there are validation errors, return to the "new" view to correct them
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }
        // If no errors, redirect to the root path ("/wishlist")
        return "redirect:/wishlist";
    }
} //End WishlistController class
