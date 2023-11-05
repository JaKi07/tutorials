# Spring Boot API CRUD Operations

This is a simple Spring Boot application that demonstrates how to create, read, update, and delete (CRUD) operations using a RESTful API.

## Table of Contents
- [Setup](#setup)
- [API Endpoints](#api-endpoints)

## Setup
1. Clone the repository:

   ```bash
   git clone https://github.com/JaKi07/tutorials.git


2. Navigate to the project folder:
    ```bash
    cd tutorials

3. Build and run the application:
    ```bash
    mvn spring-boot:run

The application will be accessible at http://localhost:8080.
You can access the H2 database console at http://localhost:8080/h2-console (if using H2) with the following settings:

- JDBC URL: `jdbc:h2:mem:tutorialsdb`
- User Name: `sa`
- Password: `password`

### API Endpoints
- GET /api/tutorials: Get a list of all tutorials.
- GET /api/tutorials/{id}: Get a specific tutorial by ID.
- POST /api/tutorials: Create a new tutorial.
- PUT /api/tutorials/{id}: Update an existing tutorial by ID.
- DELETE /api/tutorial/{id}: Delete a tutorial by ID.
- GET /health-check: Checks if the application is healthy
