@echo off
REM Hotel Reservation Backend - Dependency Installation Script
REM This script automates the download and installation of project dependencies
REM For Windows only
REM For macOS/Linux, use: install-dependencies.sh

echo.
echo ==================================
echo Hotel Reservation Backend
echo Dependency Installation Script
echo ==================================
echo.

REM Check if Maven is installed
echo Checking for Maven installation...
where mvn >nul 2>nul
if errorlevel 1 (
    echo X Maven is not installed or not in PATH
    echo.
    echo Please install Maven from: https://maven.apache.org/download.cgi
    echo Or use the Maven wrapper included in this project:
    echo   mvnw.cmd clean install
    pause
    exit /b 1
)

for /f "tokens=*" %%i in ('mvn -version ^| findstr /R "version"') do set MAVEN_VERSION=%%i
echo [OK] Found: %MAVEN_VERSION%
echo.

REM Check if Java is installed
echo Checking for Java installation...
java -version >nul 2>nul
if errorlevel 1 (
    echo X Java is not installed or not in PATH
    echo.
    echo Please install Java 21 or higher from: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)

for /f "tokens=*" %%i in ('java -version 2^>^&1 ^| findstr /R "version"') do set JAVA_VERSION=%%i
echo [OK] Found: %JAVA_VERSION%
echo.

echo ==================================
echo Downloading Dependencies
echo ==================================
echo.

REM Download dependencies
echo Running: mvn clean dependency:resolve...
echo.
call mvn clean dependency:resolve -U

if errorlevel 1 (
    echo.
    echo X Failed to download dependencies
    pause
    exit /b 1
)

echo.
echo [OK] Dependencies downloaded successfully!

echo.
echo ==================================
echo Building Project
echo ==================================
echo.

REM Build project
echo Running: mvn clean install...
echo.
call mvn clean install

if errorlevel 1 (
    echo.
    echo X Build failed. Check the error messages above.
    pause
    exit /b 1
)

echo.
echo [OK] Project built successfully!
echo.
echo Next steps:
echo 1. Run the application:
echo    mvnw.cmd spring-boot:run
echo 2. Access the API at:
echo    http://localhost:8080/api/hotels
echo.
echo 3. Available endpoints:
echo    - GET  /api/hotels/rooms
echo    - POST /api/hotels/reservations
echo.

echo ==================================
echo Installation Complete!
echo ==================================
echo.
pause

