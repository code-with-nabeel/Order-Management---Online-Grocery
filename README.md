# 🛒 Online Grocery Order Management API

A RESTful backend service built using Spring Boot to manage customers, grocery items, and orders for an online grocery system.

This project demonstrates CRUD operations, entity relationships, and clean REST API design.

---

## 🚀 Features

- Customer CRUD operations
- Grocery Item CRUD operations
- Order management
- Many-to-many & one-to-many entity relationships
- Global exception handling
- MySQL database integration
- Swagger API documentation
- JSON serialization handling for JPA relationships

---

## 🧱 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Swagger / OpenAPI
- Maven

---

## 📂 Project Structure

```
com.grocery
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── exception
 └── GroceryApplication.java
```

---

## 🗄 Database Configuration

Update `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/Grocery_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Create database manually:

```
CREATE DATABASE Grocery_db;
```

---

## ▶️ How to Run

```
git clone <your-repo-url>
cd grocery-api
mvn clean install
mvn spring-boot:run
```

Server runs at:

```
http://localhost:8080
```

---

## 📘 API Endpoints

### Customer

| Method | Endpoint |
|--------|----------|
POST | /customers  
GET | /customers  
GET | /customers/{id}  
PUT | /customers/{id}  
DELETE | /customers/{id}  

---

### Grocery Items

| Method | Endpoint |
|--------|----------|
POST | /items  
GET | /items  
GET | /items/{id}  
PUT | /items/{id}  
DELETE | /items/{id}  

---

### Orders

| Method | Endpoint |
|--------|----------|
POST | /orders  
GET | /orders  
GET | /orders/{id}  
DELETE | /orders/{id}  

---

## 🧪 Sample JSON

### Create Customer

```json
{
  "name": "Nabeel",
  "email": "nabeel@gmail.com",
  "address": "Mumbai",
  "phone": "9999999999"
}
```

### Create Grocery Item

```json
{
  "name": "Rice",
  "category": "Grains",
  "price": 50,
  "quantity": 100
}
```

### Create Order

```json
{
  "orderDate": "2026-02-17",
  "totalPrice": 100,
  "customer": { "id": 1 },
  "items": [{ "id": 1 }]
}
```

---

## 📖 Swagger Documentation

Open browser:

```
http://localhost:8080/swagger-ui.html
```

Interactive API testing available.

---

## ❌ Error Handling

- 404 → Entity not found
- 500 → Internal server error
- Global exception handler implemented

---

## 👨‍💻 Author

**Nabeel Khan**

---

## ⭐ Future Improvements

- DTO layer
- Validation annotations
- Unit testing
- JWT authentication
- Docker deployment
- Pagination & filtering
