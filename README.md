# Car Inventory Management System

A full-stack Car Inventory Management System built using **Spring Boot**, **React**, **PostgreSQL**, and **JWT Authentication**. The application allows users to browse, search, and purchase vehicles while providing administrators with complete inventory management capabilities.

---

# Features

## Authentication

- User Registration
- User Login
- JWT Token Authentication
- Protected Routes
- Logout Functionality

## Vehicle Management

- View all available vehicles
- Search vehicles by Brand and Model
- Purchase vehicles
- Automatic quantity reduction after purchase
- Purchase button disabled when stock reaches zero

## Admin Features

- Add Vehicle
- Update Vehicle
- Delete Vehicle
- Restock Vehicle

## User Interface

- Responsive Design
- Modern Dashboard
- Hero Banner
- Vehicle Cards
- Search Bar
- Mobile Friendly Layout

---

# 🛠 Technology Stack

## Frontend

- React.js
- React Router DOM
- Axios
- Bootstrap
- React Icons
- CSS3

## Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication
- Maven

## Database

- PostgreSQL

---

# Project Structure

```
Car-Inventory-System
│
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── config
│   ├── util
│   └── exception
│
└── frontend
    ├── components
    ├── pages
    ├── services
    ├── api
    ├── assets
    └── styles
```

---

# Backend Setup

### Clone Repository

```bash
git clone <repository-url>
```

### Navigate

```bash
cd backend
```

### Configure PostgreSQL

Update **application.properties**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/car_inventory
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Install Dependencies

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Backend runs on

```
http://localhost:8080
```

---

# Frontend Setup

Navigate

```bash
cd frontend
```

Install Dependencies

```bash
npm install
```

Run React Application

```bash
npm run dev
```

Frontend runs on

```
http://localhost:5173
```

---

# Authentication

The application uses **JWT (JSON Web Token)** for authentication.

Workflow

1. User Registers
2. User Logs In
3. Backend Generates JWT Token
4. Token Stored in Local Storage
5. Axios attaches JWT in Authorization Header
6. Protected APIs are accessed using the JWT Token

---

# REST API Endpoints

## Authentication

| Method | Endpoint           | Description   |
| ------ | ------------------ | ------------- |
| POST   | /api/auth/register | Register User |
| POST   | /api/auth/login    | Login User    |

---

## Vehicles

| Method | Endpoint                   | Description       |
| ------ | -------------------------- | ----------------- |
| GET    | /api/vehicle               | Get All Vehicles  |
| GET    | /api/vehicle/{id}          | Get Vehicle by ID |
| POST   | /api/vehicle               | Add Vehicle       |
| PUT    | /api/vehicle/{id}          | Update Vehicle    |
| DELETE | /api/vehicle/{id}          | Delete Vehicle    |
| POST   | /api/vehicle/{id}/purchase | Purchase Vehicle  |
| POST   | /api/vehicle/{id}/restock  | Restock Vehicle   |
| GET    | /api/vehicle/search        | Search Vehicles   |

---

# Vehicle Attributes

Each vehicle contains

- Brand
- Model
- Year
- Color
- Fuel Type
- Transmission
- Mileage
- Price
- Quantity
- Category
- VIN Number
- Vehicle Status
- Image URL

---

# Application Screens

- Login Page
- Registration Page
- Dashboard
- Search
- Vehicle Details
- Add Vehicle
- Edit Vehicle

---

# Security

- Spring Security
- JWT Authentication
- BCrypt Password Encryption
- Stateless Authentication
- Protected API Endpoints

---

# Responsive Design

The application is fully responsive and works across

- Desktop
- Laptop
- Tablet
- Mobile Devices

---

# Future Improvements

- User Profile
- Order History
- Wishlist
- Vehicle Image Upload
- Pagination
- Sorting
- Advanced Filters
- Dashboard Analytics
- Email Notifications
- Role-based UI (Admin/User)

---

# Developer

**Aditya Darji**

M.Tech Student

Full Stack Developer

---

# My AI Usage

## AI Tools Used

During the development of this project, I used the following AI tools:

- ChatGPT (OpenAI)

---

## How I Used AI

I used ChatGPT as a development assistant throughout the project. AI was used to:

### Project Planning

- Plan the project architecture.
- Break the assignment into manageable milestones.
- Decide the folder structure for both frontend and backend.

### Backend Development

- Understand and implement JWT Authentication.
- Design REST API endpoints.
- Create DTOs and validation logic.
- Resolve Spring Security configuration issues.
- Configure PostgreSQL integration.
- Debug CORS and authentication problems.
- Fix CRUD implementation issues.

### Frontend Development

- Design responsive Login and Registration pages.
- Create reusable React components.
- Build the Dashboard layout.
- Develop Vehicle Cards.
- Implement React Router navigation.
- Integrate Axios with backend APIs.
- Implement Search, Purchase, Add, Edit, and Delete functionalities.
- Improve UI responsiveness and styling.
- Debug React state management and routing issues.

### Debugging

AI assisted in identifying and resolving several issues, including:

- React Router configuration
- JWT authentication integration
- Spring Security authorization issues
- CORS configuration
- API integration
- State management bugs
- CRUD functionality issues
- Form validation problems

---

## Reflection

Using ChatGPT significantly improved my development workflow by providing guidance during implementation, debugging, and application design. Rather than generating a complete application automatically, AI acted as a development assistant that helped explain concepts, identify bugs, and suggest improvements. I reviewed, understood, and integrated the generated code into my project while making modifications wherever necessary.

AI reduced development time, improved code quality, and helped me learn best practices for building a secure full-stack application using Spring Boot, React, PostgreSQL, and JWT Authentication.

---

# License

This project was developed for academic purposes as part of a campus assignment.
