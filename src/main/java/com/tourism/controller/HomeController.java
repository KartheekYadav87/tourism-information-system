package com.tourism.controller;

import com.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the main public pages:
 * Home (landing page), About, and Gallery.
 */
@Controller
public class HomeController {

    @Autowired
    private TourismService tourismService;

    /**
     * Serves the homepage with featured attractions, hotels, and statistics.
     */
    @GetMapping("/")
    public String home(Model model) {
        // Featured 6 attractions for homepage
        model.addAttribute("featuredAttractions",
                tourismService.getAllAttractions().subList(0, 6));

        // Featured 4 hotels for homepage
        model.addAttribute("featuredHotels",
                tourismService.getAllHotels().subList(0, 4));

        // Statistics counters
        model.addAttribute("totalAttractions", tourismService.getTotalAttractions());
        model.addAttribute("totalHotels", tourismService.getTotalHotels());
        model.addAttribute("totalGuides", tourismService.getTotalGuides());

        model.addAttribute("currentPage", "home");
        model.addAttribute("pageTitle", "Tamil Nadu Tourism – Explore the Land of Temples & Tradition");
        return "index";
    }

    /**
     * Serves the About page.
     */
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("currentPage", "about");
        model.addAttribute("pageTitle", "About Us – Tamil Nadu Tourism");
        return "about";
    }

    /**
     * Serves the Gallery page with all attraction images.
     */
    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("attractions", tourismService.getAllAttractions());
        model.addAttribute("currentPage", "gallery");
        model.addAttribute("pageTitle", "Photo Gallery – Tamil Nadu Tourism");
        return "gallery";
    }
}
