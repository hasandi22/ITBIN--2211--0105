/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hasandi
 *  This class handles the database connection setup.
 *  It provides a method to get a connection to the database.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
     // Database connection url, user, password
    private static final String URL = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    
    //Establishes a connection to the database.
    public static Connection getConnection() {
        try {
            // Attempt to establish a connection to the database
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Print the stack trace if there is a SQL exception
            e.printStackTrace();
            return null;
        }
    }
}
