package com.tourism.controller;

import com.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the travel guides page.
 * Provides comprehensive travel information and tips.
 */
@Controller
public class GuideController {

    @Autowired
    private TourismService tourismService;

    /**
     * Displays all available travel guides.
     */
    @GetMapping("/guides")
    public String guides(Model model) {
        model.addAttribute("guides", tourismService.getAllGuides());
        model.addAttribute("currentPage", "guides");
        model.addAttribute("pageTitle", "Travel Guides – Tamil Nadu Tourism");
        return "guides";
    }
}
