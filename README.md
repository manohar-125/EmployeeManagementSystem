# EmployeeManagementSystem

A simple desktop-based Java Swing application to manage employee records with secure login functionality.

Features:
Admin login system
Add new employee records
Update existing employee details
View employee information in tabular format
Delete employee records
GUI built using Java Swing
Backend powered by JDBC and MySQL

Technologies Used:
Java (Swing for GUI)
JDBC (Database connectivity)
MySQL (Backend database)

Database Overview:
The application uses two main tables:
login – stores admin credentials (username and password)
employees – stores all employee details like name, phone, email, etc.

Project Structure:
Splash.java – Startup splash screen (run this first)
Login.java – Login screen for admin
Main_Class.java – Dashboard after successful login
AddEmployee.java – Add new employees
UpdateEmployee.java – Modify employee data
ViewEmployee.java – Display employees in a table
RemoveEmployee.java – Remove employee records
Conn.java – Database connection handler

How to Run:
Clone the repository
Open the project in a Java IDE (like IntelliJ or Eclipse)
Ensure MySQL is running and JDBC driver is configured in the project
Update your MySQL credentials in Conn.java file
Run Splash.java to start the application

Notes:
.gitignore includes config for IntelliJ, Eclipse, VS Code, and macOS

Admin login credentials should be stored in the login table

Author:
Shyam Manohar