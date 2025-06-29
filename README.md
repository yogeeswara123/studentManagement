A simple Java console application for managing student records using JDBC and MySQL. It allows administrators to perform CRUD operations (Create, Read, Update, Delete) on student data and view statistics like average age and grade distribution.

Features

- Admin login system
- Add new student
- View all students
- Update student information
- Delete a student record
- Search students by name or course
- View statistics (average age, grade count)

Technologies Used
- Java (JDK 17+)
- JDBC (Java Database Connectivity)
- MySQL Database
- MySQL Connector/J (JDBC Driver)

 Prerequisites

Before running the application, ensure you have the following installed:

- Java JDK 17 or above
- MySQL Server
- MySQL JDBC Driver (Connector/J)
- A MySQL database named `studentdb` (or your custom DB)

Setup & Run Instructions
Download the Project
   git clone https://github.com/your-username/studentManagement.git
   cd studentManagement
   
Create Database and Table
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(50),
    age INT,
    grade CHAR(1)
);

Configure Database Connection
String url = "jdbc:mysql://localhost:3306/studentdb";
String user = "root";
String password = "yogi7032_N$";

Add MySQL JDBC Driver
Download mysql-connector-java.jar from the official MySQL site.

Compile the Code
javac Main.java

Run the Application
java Main


