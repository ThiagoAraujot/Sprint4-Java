# Horizon - Mechanical Workshop Management System

Horizon is a mechanical workshop management system built with Java 21 (LTS), Spring Boot, and Apache Maven. It provides full RESTful CRUD (Create, Read, Update, Delete) operations for managing suppliers, mechanics (workshops), employees, customers, cars, and services. The application uses Spring Security for authentication and authorization, employing JSON Web Tokens (JWT) for stateless, secure sessions. All APIs are automatically documented and can be tested via Swagger (OpenAPI) UI.

## 🚀 Badges

![Java 21](https://img.shields.io/badge/Java-21-brightgreen)
![Maven](https://img.shields.io/badge/Maven-4.0.0-blue)
![Status](https://img.shields.io/badge/Status-In%20Development-orange)

## 🛠 Technologies Used

- **Java 21 (LTS)**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Swagger / OpenAPI**
- **Apache Maven**
- **Spring Data JPA**
- **PostgreSQL Database**

## ✅ Features

- 🔧 Full CRUD operations for:
  - Suppliers
  - Mechanics
  - Employees
  - Customers
  - Cars
  - Services
- 🔐 User authentication and authorization (JWT)
- 📄 API documentation with Swagger UI

## 📦 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/ThiagoAraujot/Sprint4-Java.git
cd Sprint4-Java
```

### 2. Build the project with Maven

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn spring-boot:run
```

### 4. Access Swagger UI

Visit: http://localhost:8080/swagger-ui.html
