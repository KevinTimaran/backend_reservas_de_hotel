#!/bin/bash
# Hotel Reservation Backend - Dependency Installation Script
# This script automates the download and installation of project dependencies
# Compatible with: macOS, Linux
# For Windows, use: install-dependencies.bat

echo "=================================="
echo "Hotel Reservation Backend"
echo "Dependency Installation Script"
echo "=================================="
echo ""

# Check if Maven is installed
echo "✓ Checking for Maven installation..."
if ! command -v mvn &> /dev/null; then
    echo "✗ Maven is not installed or not in PATH"
    echo ""
    echo "Please install Maven from: https://maven.apache.org/download.cgi"
    echo "Or use the Maven wrapper included in this project:"
    echo "  ./mvnw clean install"
    exit 1
fi

MAVEN_VERSION=$(mvn -version | head -n 1)
echo "✓ Found: $MAVEN_VERSION"
echo ""

# Check if Java is installed
echo "✓ Checking for Java installation..."
if ! command -v java &> /dev/null; then
    echo "✗ Java is not installed or not in PATH"
    echo ""
    echo "Please install Java 21 or higher from: https://www.oracle.com/java/technologies/downloads/"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | head -n 1)
echo "✓ Found: $JAVA_VERSION"
echo ""

# Confirm Java version is 21 or higher
JAVA_MAJOR_VERSION=$(java -version 2>&1 | grep -oP '(?<=version ")\d+' | head -1)
if [ "$JAVA_MAJOR_VERSION" -lt 21 ]; then
    echo "⚠ Warning: Java 21 or higher is required. You have version $JAVA_MAJOR_VERSION"
    echo "Please upgrade Java from: https://www.oracle.com/java/technologies/downloads/"
    read -p "Continue anyway? (y/n) " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        exit 1
    fi
fi

echo ""
echo "=================================="
echo "Downloading Dependencies"
echo "=================================="
echo ""

# Download dependencies
echo "Running: mvn clean dependency:resolve..."
echo ""
mvn clean dependency:resolve -U

if [ $? -eq 0 ]; then
    echo ""
    echo "✓ Dependencies downloaded successfully!"
else
    echo ""
    echo "✗ Failed to download dependencies"
    exit 1
fi

echo ""
echo "=================================="
echo "Building Project"
echo "=================================="
echo ""

# Build project
echo "Running: mvn clean install..."
echo ""
mvn clean install

if [ $? -eq 0 ]; then
    echo ""
    echo "✓ Project built successfully!"
    echo ""
    echo "Next steps:"
    echo "1. Run the application:"
    echo "   mvn spring-boot:run"
    echo "2. Access the API at:"
    echo "   http://localhost:8080/api/hotels"
    echo ""
    echo "3. Available endpoints:"
    echo "   - GET  /api/hotels/rooms"
    echo "   - POST /api/hotels/reservations"
    echo ""
else
    echo ""
    echo "✗ Build failed. Check the error messages above."
    exit 1
fi

echo "=================================="
echo "Installation Complete!"
echo "=================================="

