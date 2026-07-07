package com.tourism.model;

import java.util.List;

/**
 * Model class representing a tourist attraction in the state.
 * Each attraction includes geographic, operational, and descriptive details.
 */
public class Attraction {

    private Long id;
    private String name;
    private String district;
    private String category;       // Beach, Temple, Waterfall, Wildlife, etc.
    private String description;
    private String image;          // Image filename in /static/images/
    private String openingHours;
    private String entryFee;
    private String bestSeason;
    private double latitude;
    private double longitude;

    // --- Constructors ---

    public Attraction() {}

    public Attraction(Long id, String name, String district, String category,
                      String description, String image, String openingHours,
                      String entryFee, String bestSeason,
                      double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.category = category;
        this.description = description;
        this.image = image;
        this.openingHours = openingHours;
        this.entryFee = entryFee;
        this.bestSeason = bestSeason;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getOpeningHours() { return openingHours; }
    public void setOpeningHours(String openingHours) { this.openingHours = openingHours; }

    public String getEntryFee() { return entryFee; }
    public void setEntryFee(String entryFee) { this.entryFee = entryFee; }

    public String getBestSeason() { return bestSeason; }
    public void setBestSeason(String bestSeason) { this.bestSeason = bestSeason; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}
