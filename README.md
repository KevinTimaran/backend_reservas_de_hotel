# Hotel Reservation Backend API

A modern Spring Boot REST API for managing hotel reservations, rooms, guests, and billing. Fully translated to English with clean architecture following best practices.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Build & Run](#build--run)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)

## 🎯 Overview

The Hotel Reservation Backend is a Spring Boot 3.5.13 application that manages hotel reservations with features including:
- Room inventory management
- Reservation booking and management
- Guest information tracking
- Digital key generation for room access
- Billing and invoice generation
- Additional services management (breakfast, transfers, spa, etc.)

## ✨ Features

- **Room Management**: Manage room types (Single, Double, Suite) and room statuses (Available, Reserved, Occupied)
- **Reservation System**: Create, track, and manage reservations with check-in/check-out dates
- **Guest Management**: Store and manage guest information with contact details
- **Digital Access**: Generate digital keys with automatic expiration for room access
- **Billing**: Automatic invoice generation with tax calculations (19% default)
- **Additional Services**: Add extra services like breakfast, spa, and transfers to reservations
- **Dynamic Pricing**: Apply seasonal pricing adjustments (high/low season)
- **Error Handling**: Comprehensive exception handling with informative error messages

## 🛠️ Technology Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| Java | 21 | Programming language |
| Spring Boot | 3.5.13 | Web framework |
| Spring MVC | 3.5.13 | REST API framework |
| Maven | 3.x | Build automation |
| Lombok | Latest | Reduce boilerplate code |
| JUnit 5 | Latest | Unit testing |

## 📦 Prerequisites

### System Requirements
- **Java Development Kit (JDK):** 21 or higher
- **Maven:** 3.6.0 or higher
- **Operating System:** Windows, macOS, or Linux
- **Disk Space:** Minimum 500 MB for dependencies
- **RAM:** Minimum 2 GB

### Verify Installation

```bash
# Check Java version
java -version

# Check Maven version
mvn -version
```

## 🚀 Installation

### Step 1: Clone or Download the Repository

```bash
# If using git
git clone <repository-url>
cd backend_Reservas_de_Hotel

# Or navigate to your project directory
cd path/to/backend_Reservas_de_Hotel
```

### Step 2: Download Project Dependencies

The project uses Maven for dependency management. All dependencies will be automatically downloaded when you build the project.

#### Option A: Automatic Download (Recommended)

```bash
# Download dependencies and build
mvn clean install

# Or just download without building
mvn dependency:resolve
```

#### Option B: Using the Maven Wrapper (No Maven Installation Required)

```bash
# Windows
mvnw.cmd clean install

# macOS/Linux
./mvnw clean install
```

#### Option C: Manual Setup

If you have Maven installed globally:

```bash
mvn clean dependency:download-sources
mvn clean dependency:resolve
```

### Step 3: Verify Installation

```bash
# Compile the project
mvn compile

# If successful, you should see:
# [INFO] BUILD SUCCESS
```

## 🏗️ Build & Run

### Build the Project

```bash
# Using Maven
mvn clean install

# Using Maven Wrapper (Windows)
mvnw.cmd clean install

# Using Maven Wrapper (macOS/Linux)
./mvnw clean install
```

### Run the Application

#### Option 1: Using Spring Boot Maven Plugin

```bash
# Windows
mvnw.cmd spring-boot:run

# macOS/Linux
./mvnw spring-boot:run
```

#### Option 2: Run JAR Directly

```bash
# Build JAR first
mvn clean package

# Run JAR
java -jar target/reservation-0.0.1-SNAPSHOT.jar
```

#### Option 3: Using IDE

- Open the project in IntelliJ IDEA, Eclipse, or VS Code
- Run `ReservationApplication.java` main class
- Application starts on `http://localhost:8080`

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api/hotels
```

### Endpoints

#### 1. List All Rooms
```
GET /api/hotels/rooms
```

**Response:**
```json
[
  {
    "id": 1,
    "number": "101",
    "roomType": "SINGLE",
    "status": "AVAILABLE",
    "baseRate": 100.0
  }
]
```

#### 2. Create a Reservation
```
POST /api/hotels/reservations
Content-Type: application/json
```

**Request Body:**
```json
{
  "roomId": 1,
  "guestId": 1,
  "checkInDate": "2026-04-15",
  "checkOutDate": "2026-04-20",
  "services": [
    {
      "id": 1,
      "serviceType": "BREAKFAST",
      "description": "Continental breakfast included",
      "cost": 15.0
    }
  ]
}
```

**Response (201 Created):**
```json
{
  "reservationId": 101,
  "status": "CREATED",
  "estimatedTotal": 615.0,
  "message": "Reservation created successfully"
}
```

### Room Status Values
- `AVAILABLE` - Room is available for reservation
- `RESERVED` - Room has been reserved
- `OCCUPIED` - Guest is currently in the room

### Reservation Status Values
- `CREATED` - Reservation just created
- `CONFIRMED` - Reservation confirmed
- `CHECKED_IN` - Guest has checked in
- `CHECKED_OUT` - Guest has checked out
- `CANCELED` - Reservation canceled

### Service Types
- `SPA` - Spa services
- `BREAKFAST` - Breakfast service
- `TRANSFER` - Airport/transportation transfer

### Room Types
- `SINGLE` - Single occupancy room
- `DOUBLE` - Double occupancy room
- `SUITE` - Luxury suite

## 📂 Project Structure

```
backend_Reservas_de_Hotel/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hotel/reservation/
│   │   │       ├── ReservationApplication.java      # Main entry point
│   │   │       ├── config/
│   │   │       │   └── DataInitializer.java         # Initial data loader
│   │   │       ├── controller/
│   │   │       │   └── HotelController.java         # REST endpoints
│   │   │       ├── facade/
│   │   │       │   └── HotelFacade.java             # Business logic orchestrator
│   │   │       ├── service/
│   │   │       │   ├── RoomService.java             # Room operations
│   │   │       │   ├── AccessService.java           # Digital key generation
│   │   │       │   ├── AdditionalServiceService.java # Service management
│   │   │       │   ├── BillingService.java          # Invoice generation
│   │   │       │   └── RateService.java             # Rate calculations
│   │   │       ├── repository/
│   │   │       │   ├── RoomRepository.java          # Room data access
│   │   │       │   ├── ReservationRepository.java   # Reservation data access
│   │   │       │   └── InvoiceRepository.java       # Invoice data access
│   │   │       ├── model/
│   │   │       │   ├── Room.java                    # Room entity
│   │   │       │   ├── Reservation.java             # Reservation entity
│   │   │       │   ├── Guest.java                   # Guest entity
│   │   │       │   ├── Invoice.java                 # Invoice entity
│   │   │       │   ├── DigitalKey.java              # Digital key entity
│   │   │       │   └── AdditionalService.java       # Service entity
│   │   │       ├── dto/
│   │   │       │   ├── ReservationRequestDTO.java   # Reservation request
│   │   │       │   ├── ReservationResponseDTO.java  # Reservation response
│   │   │       │   └── ServiceRequestDTO.java       # Service request
│   │   │       ├── enums/
│   │   │       │   ├── RoomStatus.java              # Room status enum
│   │   │       │   ├── RoomType.java                # Room type enum
│   │   │       │   ├── ReservationStatus.java       # Reservation status enum
│   │   │       │   ├── Season.java                  # Season enum
│   │   │       │   └── ServiceType.java             # Service type enum
│   │   │       └── exception/
│   │   │           ├── GlobalExceptionHandler.java  # Exception handling
│   │   │           ├── BadRequestException.java     # 400 errors
│   │   │           └── ResourceNotFoundException.java # 404 errors
│   │   └── resources/
│   │       └── application.properties                # Application config
│   └── test/
│       └── java/
│           └── com/hotel/reservation/
│               └── ReservationApplicationTests.java  # Integration tests
│
├── pom.xml                      # Maven configuration
├── mvnw                         # Maven wrapper (Linux/macOS)
├── mvnw.cmd                     # Maven wrapper (Windows)
├── .gitignore                   # Git ignore rules
└── README.md                    # This file
```

## ⚙️ Configuration

### Application Properties

Edit `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/

# Application Name
spring.application.name=Hotel Reservation System

# Logging
logging.level.root=INFO
logging.level.com.hotel.reservation=DEBUG

# Data Initialization
# Set to false to skip loading test data
spring.datasource.initialization-mode=always
```

### Customizing Tax Rate

Edit `src/main/java/com/hotel/reservation/service/BillingService.java`:

```java
// Line 22: Change 0.19 (19%) to your desired tax rate
double taxes = subtotal * 0.19; // Change 0.19 to your rate
```

### Customizing Seasonal Rates

Edit `src/main/java/com/hotel/reservation/service/RateService.java`:

```java
// Line 17: Change 1.2 (20% increase) for high season
if (season == Season.HIGH) {
    return baseRate * 1.2; // Change 1.2 to your multiplier
}
```

## 🧪 Testing

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=ReservationApplicationTests
```

### Run Tests with Coverage

```bash
mvn clean test jacoco:report
```

### Expected Test Results

```
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## 🔧 Troubleshooting

### Problem: Java Version Not Compatible

**Error:** `[ERROR] Maven configuration problem: 'source' doesn't map to a valid JDK version '21'`

**Solution:**
```bash
# Check installed Java version
java -version

# If needed, install JDK 21 from https://www.oracle.com/java/technologies/downloads/
# Then set JAVA_HOME environment variable
```

### Problem: Maven Not Found

**Error:** `'mvn' is not recognized as an internal or external command`

**Solution:**
```bash
# Use Maven wrapper instead (included in project)
# Windows
mvnw.cmd clean install

# macOS/Linux
./mvnw clean install
```

### Problem: Dependency Download Failed

**Error:** `[ERROR] Failed to execute goal on project reservation`

**Solution:**
```bash
# Clear Maven cache and retry
mvn clean install -U

# Or manually update dependencies
mvn dependency:resolve -U
```

### Problem: Port 8080 Already In Use

**Error:** `Address already in use`

**Solution:**
```bash
# Option 1: Change port in application.properties
server.port=8081

# Option 2: Kill process using port 8080
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Linux/macOS
lsof -i :8080
kill -9 <PID>
```

### Problem: Build Success but Application Won't Start

**Error:** `Application context initialization failed`

**Solution:**
```bash
# Clean rebuild
mvn clean install

# Check logs for specific error messages
mvn spring-boot:run
```

## 📝 Development Guidelines

### Code Style
- Use English for all identifiers, methods, and comments
- Follow Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Keep methods focused on single responsibility
- Add comments for complex business logic

### Adding New Features
1. Create model class in `model/`
2. Create repository in `repository/`
3. Create service in `service/`
4. Create/update controller endpoints in `controller/`
5. Create DTOs in `dto/`
6. Add tests for new functionality

### Database Notes
Current implementation uses in-memory storage (`ConcurrentHashMap`). To integrate with a real database:
1. Add Spring Data JPA dependency to `pom.xml`
2. Replace repository implementations with JPA repositories
3. Update model classes with `@Entity` and `@Table` annotations
4. Configure database properties in `application.properties`

## 🚢 Deployment

### Build Production JAR

```bash
mvn clean package -DskipTests
```

### Run in Production

```bash
java -jar target/reservation-0.0.1-SNAPSHOT.jar
```

### Docker (Optional)

Create `Dockerfile`:
```dockerfile
FROM openjdk:21-slim
COPY target/reservation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Build and run:
```bash
docker build -t hotel-api .
docker run -p 8080:8080 hotel-api
```

## 📄 License

This project is proprietary. All rights reserved.

## 👥 Contributors

- Development Team - Hotel Reservation System Project

## 📞 Support

For issues, questions, or contributions:
1. Check the [Troubleshooting](#troubleshooting) section
2. Review API documentation above
3. Check application logs for error details

## 📅 Version History

### v0.0.1 (Current)
- Initial release
- Complete English translation
- Full reservation management system
- Billing and invoicing
- Digital key generation

---

**Last Updated:** April 10, 2026

