/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * This class represents the model for a Users in the system.
 */

public class UserModel {
     // Method to authenticate user based on provided username and password
    public boolean authenticate(String username, String password) {  
        boolean isAuthenticated = false;

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beauty product shopping system", "root", "");
            // SQL query to check if the provided username and password match
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            // If a matching user is found, set isAuthenticated to true
            if (rs.next()) {
                isAuthenticated = true;
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }
    
    // Method to sign up a new user
    public boolean signUp(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beauty product shopping system", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
}


