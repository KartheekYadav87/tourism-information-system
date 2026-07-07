package com.tourism.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC web configuration.
 * Registers static resources and custom view controller mappings.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Registers static resource handlers for CSS, JS, and images.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
    }

    /**
     * Maps simple view names without controller logic if needed.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Error page fallback – handled via ErrorController but kept here for safety
        registry.addViewController("/error").setViewName("error");
    }
}
