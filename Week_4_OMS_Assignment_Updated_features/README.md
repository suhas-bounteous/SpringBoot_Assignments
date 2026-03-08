# Trading Order Microservices System

## Overview

This project is a simple microservices-based backend system built using Spring Boot. It simulates a basic trading platform where users can place buy or sell orders, and the system processes them asynchronously while also collecting analytics data.

The application is divided into multiple microservices that communicate with each other using Spring Cloud components. Authentication is handled using JWT tokens.

---

## Architecture

The system consists of the following services:

### 1. Discovery Service

Acts as a service registry using Netflix Eureka.
All services register themselves here so they can discover and communicate with each other.

### 2. Auth Service

Handles user authentication and generates JWT tokens.
Users must log in through this service before accessing other APIs.

### 3. API Gateway

Acts as the single entry point for all client requests.
It validates JWT tokens and routes requests to the appropriate microservice.

### 4. Order Service

Responsible for creating and managing trading orders.
Orders are stored in a database and processed asynchronously.

### 5. Analytics Service

Collects and exposes analytics data related to orders, such as order counts and types.

---

## Technologies Used

* Java (JDK 25)
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Cloud Gateway
* Netflix Eureka
* Spring Data JPA
* OpenFeign
* Spring AOP
* H2 Database
* Maven

---

## Project Structure

trading-platform
│
├── discovery-service
├── auth-service
├── api-gateway
├── order-service
└── analytics-service

Each service runs independently and registers itself with the discovery server.

---

## Authentication Flow

1. The user logs in through the Auth Service.
2. Auth Service verifies the credentials and returns a JWT token.
3. The client includes the token in the Authorization header for all requests.
4. The API Gateway validates the token before forwarding the request to the appropriate service.

Example header:

Authorization: Bearer <JWT_TOKEN>

---

## Roles

The system supports two user roles.

ADMIN

* Can create orders
* Has full access to APIs

VIEWER

* Can view analytics
* Cannot create orders

Role-based access is enforced using Spring Security.

---

## Running the Application

Start the services in the following order:

1. discovery-service
2. auth-service
3. analytics-service
4. order-service
5. api-gateway

After all services start successfully, the API Gateway will expose the APIs.

Gateway base URL:

http://localhost:8080

---

## API Examples

### Login

POST /auth/login

Request body:

{
"username": "admin",
"password": "admin123"
}

Response:

{
"token": "JWT_TOKEN"
}

---

### Create Order

POST /orders

Headers:

Authorization: Bearer <JWT_TOKEN>

Request body:

{
"customerId": "C101",
"type": "BUY",
"amount": 1200
}

Orders are processed asynchronously by the order worker.

---

### View Analytics

GET /analytics/metrics

Returns statistics related to the orders processed by the system.

---

## Database

The Order Service uses an H2 in-memory database to store order data.

You can access the H2 console at:

http://localhost:8081/h2-console

Connection details:

JDBC URL: jdbc:h2:mem:orders-db
Username: sa
Password: (leave blank)

Example query:

SELECT * FROM ORDERS;

---

## Logging

Spring AOP is used to log important events such as:

* Order creation
* Order processing
* Service communication

These logs help track how requests move through the system.

---

## Notes

This project demonstrates basic microservices architecture using Spring Boot and Spring Cloud. It includes service discovery, secure API access with JWT, inter-service communication, asynchronous processing, and database persistence.

The goal of the project is to understand how different services work together in a distributed backend system.
