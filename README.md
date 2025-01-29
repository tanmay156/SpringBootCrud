# Spring Boot CRUD Application using JDBC

This is a **Spring Boot** application that performs CRUD operations on **User Data** using **JDBC** and **MySQL** as the database.

## 🛠 Tech Stack

- **Backend:** Spring Boot 3.4.1, Java
- **Database:** MySQL
- **API Communication:** RESTful APIs
- **ORM:** JDBC Template

## 🔧 How to Run the Spring Boot Backend

### 1️⃣ Clone the Repository
```sh
 git clone <repository-url>
 cd <project-directory>
```

### 2️⃣ Configure MySQL Database
- Create a MySQL database.
- Update `application.properties` with database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Install Dependencies & Run Backend
```sh
 mvn spring-boot:run
```
The backend will be available at `http://localhost:8082`.

## 📦 Dependencies to Install

Ensure you have the following dependencies in `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

## 📌 Author

- **Tanmay Jadhav**

Feel free to contribute! 🚀

