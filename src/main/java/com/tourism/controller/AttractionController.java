package com.tourism.controller;

import com.tourism.model.Attraction;
import com.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Controller for tourist attraction pages.
 * Handles the attractions listing and individual attraction detail views.
 */
@Controller
public class AttractionController {

    @Autowired
    private TourismService tourismService;

    /**
     * Displays all tourist attractions with search and filter options.
     */
    @GetMapping("/attractions")
    public String attractions(Model model) {
        model.addAttribute("attractions", tourismService.getAllAttractions());
        model.addAttribute("currentPage", "attractions");
        model.addAttribute("pageTitle", "Tourist Attractions – Tamil Nadu Tourism");
        return "attractions";
    }

    /**
     * Displays detailed information about a specific attraction by ID.
     * Falls back to error view if attraction is not found.
     */
    @GetMapping("/attractions/{id}")
    public String attractionDetails(@PathVariable Long id, Model model) {
        Optional<Attraction> attractionOpt = tourismService.getAttractionById(id);

        if (attractionOpt.isEmpty()) {
            return "error";
        }

        Attraction attraction = attractionOpt.get();
        model.addAttribute("attraction", attraction);

        // Provide nearby attractions (same category, excluding current)
        model.addAttribute("nearbyAttractions",
                tourismService.getAllAttractions().stream()
                        .filter(a -> a.getCategory().equals(attraction.getCategory())
                                && !a.getId().equals(id))
                        .limit(3)
                        .toList());

        model.addAttribute("currentPage", "attractions");
        model.addAttribute("pageTitle", attraction.getName() + " – Tamil Nadu Tourism");
        return "attraction-details";
    }
}
