# Project Dependencies - Hotel Reservation Backend

## Build System: Maven 3.6+

This project uses **Maven** for dependency management. All dependencies are defined in `pom.xml` and automatically downloaded during the build process.

---

## Dependency Installation Methods

### Method 1: Automatic Installation Scripts (Recommended)

#### Windows
```bash
install-dependencies.bat
```
Double-click or run from command prompt. This script will:
- Verify Java 21+ installation
- Verify Maven installation
- Download all dependencies
- Build the project
- Display next steps

#### macOS/Linux
```bash
chmod +x install-dependencies.sh
./install-dependencies.sh
```

This script will:
- Verify Java 21+ installation
- Verify Maven installation
- Download all dependencies
- Build the project
- Display next steps

---

### Method 2: Maven Wrapper (No Maven Installation Needed)

#### Windows
```bash
mvnw.cmd clean install
```

#### macOS/Linux
```bash
./mvnw clean install
```

---

### Method 3: Global Maven Installation

If you have Maven installed globally:

#### Download Dependencies Only
```bash
mvn dependency:resolve
mvn dependency:resolve-sources
```

#### Download and Build
```bash
mvn clean install
```

#### Download Specific Plugin Dependencies
```bash
mvn dependency:tree
```

---

## Download Location

All dependencies will be downloaded to:
- **Windows:** `%USERPROFILE%\.m2\repository`
- **macOS/Linux:** `~/.m2/repository`

Total size: ~500 MB

---

## Core Dependencies

```xml
<!-- Spring Boot Starter Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Boot Starter Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Lombok (Optional but recommended) -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- Spring Boot Starter Test -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

---

## Complete Dependency Tree

```
com.hotel:reservation
├── org.springframework.boot:spring-boot-starter-web
│   ├── org.springframework.boot:spring-boot
│   ├── org.springframework:spring-webmvc
│   ├── org.springframework:spring-web
│   ├── org.springframework:spring-core
│   ├── org.springframework:spring-beans
│   ├── org.springframework.boot:spring-boot-starter-tomcat
│   │   ├── org.apache.tomcat.embed:tomcat-embed-core
│   │   ├── org.apache.tomcat.embed:tomcat-embed-websocket
│   │   └── org.apache.tomcat.embed:tomcat-embed-el
│   └── org.springframework:spring-jcl
├── org.springframework.boot:spring-boot-starter-validation
│   ├── org.springframework:spring-context
│   ├── jakarta.validation:jakarta.validation-api
│   ├── org.hibernate.validator:hibernate-validator
│   └── org.jboss.logging:jboss-logging
├── org.projectlombok:lombok
├── org.springframework.boot:spring-boot-starter-test
│   ├── org.springframework.boot:spring-boot-test
│   ├── junit:junit-jupiter
│   ├── org.mockito:mockito-core
│   ├── org.mockito:mockito-junit-jupiter
│   └── org.assertj:assertj-core
└── Java Platform (Java 21 standard library)
```

---

## Dependency Sizes

| Dependency | Size | Purpose |
|-----------|------|---------|
| spring-boot-starter-web | 15 MB | Web framework |
| spring-boot-starter-validation | 8 MB | Input validation |
| lombok | 2 MB | Code generation |
| spring-boot-starter-test | 80 MB | Testing |
| **Total** | **~500 MB** | All dependencies |

---

## Troubleshooting Dependency Issues

### Issue: "Failed to execute goal on project"

**Solution:**
```bash
# Clear Maven cache and retry
mvn clean install -U

# Force download of snapshots
mvn dependency:resolve -U
```

### Issue: "Network issues preventing download"

**Solution - Use offline mode:**
```bash
# First, download all dependencies online
mvn dependency:resolve

# Then build offline
mvn clean install -o
```

### Issue: "Proxy/Firewall blocking downloads"

**Solution - Configure Maven proxy in `~/.m2/settings.xml`:**
```xml
<settings>
  <proxies>
    <proxy>
      <id>proxy-server</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.yourcompany.com</host>
      <port>8080</port>
      <username>your-username</username>
      <password>your-password</password>
      <nonProxyHosts>localhost,127.0.0.1</nonProxyHosts>
    </proxy>
  </proxies>
</settings>
```

### Issue: "Out of disk space"

**Solution - Clean up Maven cache:**
```bash
# Remove old artifacts
rm -rf ~/.m2/repository

# Re-download (this will clear cache)
mvn clean install
```

---

## Verify Installation

After installation, verify all dependencies are present:

```bash
# Display dependency tree
mvn dependency:tree

# Check specific dependency
mvn dependency:get -Dartifact=org.springframework.boot:spring-boot:3.5.13
```

---

## Maven Repository Configuration

The project uses the default Maven Central Repository:
- **Repository:** https://repo.maven.apache.org/maven2/
- **Automatic mirrors:** Maven handles this automatically

To use a different repository, edit `pom.xml`:
```xml
<repositories>
    <repository>
        <id>my-repo</id>
        <url>https://my-repository.com/maven2</url>
    </repository>
</repositories>
```

---

## Offline Development

Once dependencies are downloaded, you can work offline:

```bash
# Build in offline mode
mvn clean install -o

# Run in offline mode
mvnw.cmd spring-boot:run -o
```

---

## Java Version Requirements

The project requires **Java 21 or higher**:

```bash
# Verify Java version
java -version

# Should output: openjdk version "21" or higher
```

If you need to update Java:
1. Download Java 21 from: https://www.oracle.com/java/technologies/downloads/
2. Set `JAVA_HOME` environment variable
3. Verify: `java -version`

---

## Maven Configuration (pom.xml)

Key settings in `pom.xml`:

```xml
<java.version>21</java.version>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.5.13</version>
</dependency>
```

---

## Next Steps

After downloading dependencies:

1. **Build the project:**
   ```bash
   mvn clean install
   ```

2. **Run tests:**
   ```bash
   mvn test
   ```

3. **Start the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API:**
   ```
   http://localhost:8080/api/hotels
   ```

---

## Additional Resources

- **Maven Documentation:** https://maven.apache.org/guides/
- **Spring Boot Dependencies:** https://docs.spring.io/spring-boot/docs/3.5.13/reference/html/dependency-management.html
- **Java 21 Features:** https://www.oracle.com/java/technologies/java21-whats-new.html
- **Troubleshooting:** See README.md

---

**Last Updated:** April 10, 2026

