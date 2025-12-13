//Task 1: Library Management System with JDBC
// Description: Develop a Library Management System using Java and JDBC for database connectivity. The system should allow adding, borrowing, and returning books.
// Objectives:
//Set up a database (e.g., MySQL) with tables for Books,Users, and Transactions.
 //Implement CRUD operations using JDBC for managing books and users.
 //Handle transactions when books are borrowed or returned.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class L3task1 {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }


        


    }


    
}
