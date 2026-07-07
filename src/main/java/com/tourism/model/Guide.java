package com.tourism.model;

/**
 * Model class representing a travel guide entry.
 * Each guide covers a specific travel topic with detailed content.
 */
public class Guide {

    private Long id;
    private String title;
    private String content;        // Detailed multi-paragraph guide text
    private String icon;           // Font Awesome icon class
    private String category;       // Transportation, Food, Safety, etc.

    // --- Constructors ---

    public Guide() {}

    public Guide(Long id, String title, String content, String icon, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.icon = icon;
        this.category = category;
    }

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
