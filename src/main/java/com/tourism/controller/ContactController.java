package com.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for the Contact page.
 * Handles display of the contact form and form submission feedback.
 */
@Controller
public class ContactController {

    /**
     * Displays the contact page with address, phone, email, and form.
     */
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("currentPage", "contact");
        model.addAttribute("pageTitle", "Contact Us – Tamil Nadu Tourism");
        return "contact";
    }

    /**
     * Handles contact form submission.
     * In a real system this would send an email or save to a database.
     */
    @PostMapping("/contact")
    public String submitContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String subject,
            @RequestParam String message,
            Model model) {

        // TODO: Integrate with email service or database in production
        model.addAttribute("successMessage",
                "Thank you, " + name + "! Your message has been received. " +
                "We will get back to you at " + email + " within 2-3 business days.");
        model.addAttribute("currentPage", "contact");
        model.addAttribute("pageTitle", "Contact Us – Tamil Nadu Tourism");
        return "contact";
    }
}
