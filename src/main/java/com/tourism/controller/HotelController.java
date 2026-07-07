package com.tourism.controller;

import com.tourism.model.Hotel;
import com.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Controller for hotel listing and detail pages.
 * Provides information about hotels and booking links.
 */
@Controller
public class HotelController {

    @Autowired
    private TourismService tourismService;

    /**
     * Displays all available hotels with star ratings, prices, and amenities.
     */
    @GetMapping("/hotels")
    public String hotels(Model model) {
        model.addAttribute("hotels", tourismService.getAllHotels());
        model.addAttribute("currentPage", "hotels");
        model.addAttribute("pageTitle", "Hotels & Accommodation – Tamil Nadu Tourism");
        return "hotels";
    }

    /**
     * Displays detailed information about a specific hotel by ID.
     * Falls back to error view if hotel is not found.
     */
    @GetMapping("/hotels/{id}")
    public String hotelDetails(@PathVariable Long id, Model model) {
        Optional<Hotel> hotelOpt = tourismService.getHotelById(id);

        if (hotelOpt.isEmpty()) {
            return "error";
        }

        Hotel hotel = hotelOpt.get();
        model.addAttribute("hotel", hotel);

        // Suggest similar hotels in same category, excluding current
        model.addAttribute("similarHotels",
                tourismService.getAllHotels().stream()
                        .filter(h -> h.getCategory().equals(hotel.getCategory())
                                && !h.getId().equals(id))
                        .limit(3)
                        .toList());

        model.addAttribute("currentPage", "hotels");
        model.addAttribute("pageTitle", hotel.getName() + " – Tamil Nadu Tourism");
        return "hotel-details";
    }
}
