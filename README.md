# TN Tourism Information System

A complete tourism portal for the State Tourism Department, built with Java Spring Boot and Thymeleaf.

## Technologies Used
- Java 21 (or 17)
- Spring Boot 3.2.x
- Spring Web (MVC)
- Thymeleaf Templating Engine
- HTML5, CSS3, JavaScript (Vanilla)
- Bootstrap 5 for responsive layouts
- FontAwesome 6 for icons
- Maven Build System

## Features
- **Modern Responsive UI**: Built with Bootstrap 5 and custom CSS for a premium look.
- **Dynamic Content rendering**: Uses Thymeleaf to render server-side data models.
- **Client-Side Live Filtering**: Vanilla JS implementation for fast search and category filtering of attractions and hotels without page reloads.
- **Masonry Gallery**: Responsive image gallery viewing.
- **Ready for Production**: Actuator and Prometheus endpoints configured. Code structured for easy Dockerization and Kubernetes deployment.

## Project Structure
Standard Maven directory layout is used:
- `src/main/java`: Contains the Spring Boot application, Configuration, Models, Controllers, and Service logic.
- `src/main/resources`: Contains application properties, static files (CSS, JS, images), and Thymeleaf HTML templates.

## How to Run Locally

### Prerequisites
- JDK 17 or higher
- Maven 3.8+ (or use the provided wrapper)

### Running the Application

1. From the root directory, run the Maven wrapper:
```bash
# Windows
.\mvnw.cmd spring-boot:run

# Mac/Linux
./mvnw spring-boot:run
```

2. Open your browser and navigate to:
```
http://localhost:8081
```

### Endpoints
- `/` - Homepage
- `/attractions` - List all tourist attractions
- `/attractions/{id}` - Details for a specific attraction
- `/hotels` - List all hotels
- `/hotels/{id}` - Details for a specific hotel
- `/guides` - Travel guides and tips
- `/gallery` - Image gallery
- `/about` - About the Tourism Department
- `/contact` - Contact Form

## Future Enhancements
- Connect `TourismService` to a real database using Spring Data JPA.
- Implement user authentication with Spring Security.
- Deploy to Kubernetes cluster with Jenkins CI/CD pipeline.
- Implement booking integration for hotels and entry tickets.
