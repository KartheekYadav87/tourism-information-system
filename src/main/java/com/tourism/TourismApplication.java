package com.tourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Tourism Information System Spring Boot application.
 * This application serves as a portal for the state tourism department,
 * helping tourists discover attractions, hotels, travel guides, and more.
 */
@SpringBootApplication
public class TourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourismApplication.class, args);
    }
}
