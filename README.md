# 🚍 Smart Vehicle Ticket Booking and Reservation Management System

A Spring Boot backend application for managing vehicle ticket booking, seat reservation, route management, and ticket generation with JWT-based authentication and PDF ticket download.

---

## 📌 Project Overview

This system allows users to book seats in vehicles (bus/transport), manage routes, and generate tickets. It includes role-based access for ADMIN and USER, secure authentication using JWT, and automatic ticket generation after booking.

---

## ✨ Features

### 🔐 Authentication & Security
- User Registration
- User Login
- JWT Token-based Authentication
- Role-Based Access Control (ADMIN / USER)
- Password Encryption using BCrypt

---

### 🚗 Vehicle Management (Admin)
- Add Vehicle
- Update Vehicle
- Delete Vehicle
- View All Vehicles

---

### 🛣️ Route Management
- Add Route (Source → Destination)
- Assign Vehicle to Route
- Search Available Routes
- View All Routes

---

### 🎫 Booking System
- Book Seats in a Vehicle
- Multiple Seat Selection
- Prevent Double Booking
- Automatic Seat Availability Update
- Booking Confirmation System

---

### 🧾 Ticket System
- Automatic Ticket Generation after booking
- Unique Ticket Number
- View Ticket Details
- PDF Ticket Download Feature

---

### 📊 Admin Dashboard
- Total Users Count
- Total Vehicles Count
- Total Bookings Count
- Total Revenue Calculation

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- iTextPDF (for ticket generation)

---

## 🗂️ Project Structure


com.vehicle.ticketbooking
│
├── Controller
├── Service
├── ServiceImpl
├── Entity
├── Repository
├── Dto
├── Security
├── Config


---

## 🔐 Security Implementation

- Stateless authentication using JWT
- Role-based API access control
- BCrypt password encryption
- Secure REST APIs

---

## 📡 Sample APIs

### Auth
- POST `/api/auth/register`
- POST `/api/auth/login`

### Vehicle
- POST `/api/vehicles/add`
- GET `/api/vehicles/all`

### Route
- POST `/api/routes/add`
- GET `/api/routes/all`

### Booking
- POST `/api/bookings/book`

### Ticket
- GET `/api/tickets/{ticketNumber}`
- GET `/api/tickets/pdf/{ticketNumber}`

---

## 📄 PDF Ticket Feature

After booking, users can download a professional PDF ticket containing:
- Ticket Number
- Passenger Details
- Route Information
- Seat Numbers
- Total Fare
- Booking Status

---

## 🚧 Future Enhancements (Not Implemented Yet)

The following features are planned for future versions:

- 📧 Email Ticket Sending System
- 💳 Online Payment Integration
- 📱 QR Code Ticket Generation
- 📲 SMS Notification System
- 🌐 Frontend using React.js
- ☁️ Deployment on AWS / Docker
