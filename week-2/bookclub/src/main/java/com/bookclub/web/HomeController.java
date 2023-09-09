/*
   Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Additional modifications by Nguyen, T. Student 2023
*/

// Import necessary Spring framework classes
package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController
{
    // Handles HTTP GET requests to the root path ("/") and displays the "index" view
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model)
    {
        return "index";
    } // End showHome

    // Handles HTTP GET requests to the "/about" path and displays the "about" view
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model)
    {
        return "about";
    } // End showAboutUs

    // Handles HTTP GET requests to the "/contact" path and displays the "contact" view
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model)
    {
        return "contact";
    } // End showContactUs
} // End HomeController
