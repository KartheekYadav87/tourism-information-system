package com.tourism.model;

import java.util.List;

/**
 * Model class representing a hotel in the tourism system.
 * Contains details for display, pricing, amenities, and booking integration.
 */
public class Hotel {

    private Long id;
    private String name;
    private String location;
    private int stars;                  // 1 to 5
    private double pricePerNight;       // Price in INR
    private List<String> amenities;
    private String bookingURL;
    private String image;               // Image filename in /static/images/
    private String category;            // Luxury, Budget, Resort, Business
    private String description;
    private String phone;
    private String email;

    // --- Constructors ---

    public Hotel() {}

    public Hotel(Long id, String name, String location, int stars,
                 double pricePerNight, List<String> amenities,
                 String bookingURL, String image,
                 String category, String description,
                 String phone, String email) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        this.bookingURL = bookingURL;
        this.image = image;
        this.category = category;
        this.description = description;
        this.phone = phone;
        this.email = email;
    }

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getStars() { return stars; }
    public void setStars(int stars) { this.stars = stars; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public List<String> getAmenities() { return amenities; }
    public void setAmenities(List<String> amenities) { this.amenities = amenities; }

    public String getBookingURL() { return bookingURL; }
    public void setBookingURL(String bookingURL) { this.bookingURL = bookingURL; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
