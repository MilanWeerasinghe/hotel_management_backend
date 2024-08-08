# Summer Hotel Booking System

## Overview

The **Summer Hotel Booking System** is a microservice-based application designed to manage hotel bookings, rooms, and users efficiently. The system is built with Spring Boot for the backend and React for the frontend. It also integrates Keycloak for authentication ensuring secure access to the system's resources.

## Features

- **User Management**: Register, authenticate.
- **Room Management**: Add, update, and check the availability of rooms.
- **Booking Management**: Book available rooms and manage bookings.
- **API Gateway**: Inter communication access to microservices.
- **Service Discovery**: Eureka Server for microservice registration and discovery.
- **Security**: Integrated with Keycloak for secure user authentication.

## Microservices

- **Booking Service**: Handles room bookings, including checking availability and managing booking records.
- **Room Service**: Manages room data, including adding new rooms, updating existing ones, and checking room availability.
- **User Service**: Manages user data, including registration for now.

## Technology Stack

### Backend

- **Spring Boot**: Java-based framework for building microservices.
- **Spring Security**: Securing microservices with OAuth2 and Keycloak.
- **MySQL**: Relational database management system.
- **Eureka Server**: Service discovery for microservices.
- **Keycloak**: Identity and access management solution.

---

