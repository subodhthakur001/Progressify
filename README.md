# Progressify

## Overview

**Progressify** is a web application designed to track workouts, measure progressive overload, and compare previous and current performance metrics. Built using Spring Boot, MySQL, and Spring Data JPA, Progressify helps users monitor their fitness progress over time.

## Features

- **Workout Tracking**: Log and track your workout sessions.
- **Progressive Overload Tracking**: Measure and track progressive overload to ensure continuous improvement.
- **Performance Comparison**: Compare past workout performance with current performance to evaluate progress.

## Technology Stack

- **Backend**: Spring Boot
- **Database**: MySQL
- **ORM**: Spring Data JPA

## Project Structure

- `src/main/java/com/example/progressify/`:
  - `controller/`: Contains REST controllers for handling API requests.
  - `service/`: Contains service classes for business logic.
  - `repository/`: Contains repository interfaces for data access.
  - `entity/`: Contains JPA entity classes.
  - `dto/`: Contains Data Transfer Objects (DTOs) for API communication.

- `src/main/resources/`:
  - `application.properties`: Configuration file for database and application settings.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- MySQL database server
- Maven (for managing dependencies and building the project)

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/progressify.git
    cd progressify
    ```

2. Configure the database connection:
   - Edit `src/main/resources/application.properties` to include your MySQL database details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/progressify
     spring.datasource.username=yourusername
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Build the project:
    ```sh
    mvn clean install
    ```

4. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### API Endpoints

- **Create Workout**
  - `POST /api/workouts`
  - Request body: JSON object with workout details

- **Get Workout by ID**
  - `GET /api/workouts/{id}`

- **Get All Workouts**
  - `GET /api/workouts`

- **Update Workout**
  - `PUT /api/workouts/{id}`
  - Request body: JSON object with updated workout details

- **Delete Workout**
  - `DELETE /api/workouts/{id}`

- **Get Performance Comparison**
  - `GET /api/performance/comparison?startDate={startDate}&endDate={endDate}`

## Running the Tests

Run the unit tests to ensure the application is working as expected:
```sh
mvn test
