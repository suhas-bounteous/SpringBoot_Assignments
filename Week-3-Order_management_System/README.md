# Order Management System

A backend REST API built using Spring Boot for managing customer orders.  
This project demonstrates clean architecture, layered design, and structured exception handling in a Java-based web application.

---

## Overview

The Order Management System provides a structured API to perform core order management operations.  
It follows standard backend development practices with clear separation of concerns between layers.

This project is suitable for learning purposes and portfolio demonstration.

---

## Features

- Create new orders  
- Retrieve a single order by ID  
- Retrieve all orders  
- Update existing orders  
- Delete orders  
- Global exception handling  
- Clean layered architecture  

---

## Architecture

The application follows a standard layered structure:

**Controller Layer**  
Handles HTTP requests and responses.

**Service Layer**  
Contains business logic and validation.

**Repository Layer**  
Manages data storage operations.

**Model Layer**  
Defines entities and enums.

**Exception Layer**  
Provides centralized error handling using a global exception handler.

This design improves maintainability, readability, and testability.

---

## Tech Stack

- Java 17  
- Spring Boot  
- Spring Web  
- Maven  
- JUnit 5  
- RESTful API Design  

---

## Getting Started

### Prerequisites

- Java 17 or higher  
- Maven 3.8 or higher  

### Clone the Repository

```bash
git clone <repository-url>
cd oms_selected
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

You can also run the main class directly:

```
OmsApplication.java
```

---

## API Endpoints

### Orders

| Method | Endpoint        | Description           |
|--------|----------------|-----------------------|
| POST   | /orders        | Create a new order    |
| GET    | /orders/{id}   | Get order by ID       |
| GET    | /orders        | Get all orders        |
| PUT    | /orders/{id}   | Update existing order |
| DELETE | /orders/{id}   | Delete order          |

---

## Sample Request

**Create Order**

```http
POST /orders
Content-Type: application/json
```

```json
{
  "customerName": "John Doe",
  "product": "Laptop",
  "quantity": 1,
  "price": 1200.00
}
```

---

## Testing

Run unit tests using:

```bash
mvn test
```

Tests are implemented using JUnit 5 to validate service and controller logic.

---

## Configuration

Application configuration is located in:

```
src/main/resources/application.properties
```

You can modify server port, logging levels, and other application settings there.

---

## Project Purpose

This project was built to demonstrate:

- Clean backend architecture  
- REST API design principles  
- Structured exception handling  
- Proper Spring Boot project organization  

It can serve as a foundational backend template for larger systems.
