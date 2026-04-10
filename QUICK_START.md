# Quick Start Guide - Hotel Reservation Backend

## 🚀 Quick Installation (2 minutes)

### Prerequisites
- Java 21 or higher installed
- Maven 3.6+ installed (or use the included Maven Wrapper)

### Installation Steps

#### Windows Users
```bash
# Option 1: Double-click this file to auto-install
install-dependencies.bat

# Option 2: Manual install
mvnw.cmd clean install
```

#### macOS/Linux Users
```bash
# Option 1: Run the auto-install script
chmod +x install-dependencies.sh
./install-dependencies.sh

# Option 2: Manual install
./mvnw clean install
```

#### Manual Install (Any OS)
```bash
# If Maven is installed globally
mvn clean install

# Or using Maven Wrapper (no Maven installation needed)
mvn clean install
```

---

## 📚 Dependencies Overview

### Core Dependencies
- **Spring Boot Starter Web** - REST API framework
- **Spring Boot Starter Validation** - Input validation
- **Lombok** - Reduce boilerplate code
- **JUnit 5** - Unit testing

### All Dependencies
See `pom.xml` for complete list and versions.

---

## ▶️ Running the Application

### Start the Server
```bash
# Windows
mvnw.cmd spring-boot:run

# macOS/Linux
./mvnw spring-boot:run
```

### Access the API
```
http://localhost:8080/api/hotels
```

### Available Endpoints
```
GET  /api/hotels/rooms                    # List all rooms
POST /api/hotels/reservations             # Create new reservation
```

---

## 🧪 Running Tests

```bash
# Windows
mvnw.cmd test

# macOS/Linux
./mvnw test
```

---

## 📋 Dependency Details

| Dependency | Version | Purpose |
|------------|---------|---------|
| Spring Boot Starter Web | 3.5.13 | REST API framework |
| Spring Boot Starter Validation | 3.5.13 | Input validation |
| Lombok | Latest | Code generation |
| JUnit 5 | Included | Testing framework |

---

## 🔗 Useful Links

- **Java Downloads:** https://www.oracle.com/java/technologies/downloads/
- **Maven Downloads:** https://maven.apache.org/download.cgi
- **Spring Boot Docs:** https://spring.io/projects/spring-boot
- **API Documentation:** See README.md

---

## ❓ Troubleshooting

### Java Not Found
```bash
# Install Java 21 from: https://www.oracle.com/java/technologies/downloads/
# Then verify: java -version
```

### Maven Not Found
```bash
# Use included Maven Wrapper instead:
# Windows: mvnw.cmd clean install
# macOS/Linux: ./mvnw clean install
```

### Port 8080 In Use
```bash
# Change port in src/main/resources/application.properties
server.port=8081
```

---

## 📞 Need Help?

1. Check README.md for detailed documentation
2. Review error messages in console
3. Ensure Java 21+ is installed: `java -version`
4. Try cleaning and rebuilding:
   ```bash
   mvnw clean install
   ```

---

**Last Updated:** April 10, 2026

