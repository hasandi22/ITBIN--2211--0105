/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hasandi
 * This class represents the database operations for deleting entries to different tables.
 * It has methods to delete products, customers, and sellers
 */
public class DBDelete {
    // Database connection URL, username, and password
    private final String url = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private final String user = "root";
    private final String password = "";
    
     //Deletes a product from the database.
    public boolean deleteProduct(String id){
        
        String query = "DELETE FROM products WHERE id = ?";
        
        boolean status = false;

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            // Set the ID parameter for the prepared statement
            pstmt.setString(1, id);
            // Execute the delete statement and check if any rows were affected
            status = pstmt.executeUpdate()>0; 
        } catch (SQLException e) {
            System.err.println("Error deleting product with ID " + id);
            e.printStackTrace();
        }
        return status;
    
    }
     //Deletes acustomer from the database.
    public boolean deleteCustomer(String id) {
        String query = "DELETE FROM customer WHERE id = ?";
        
        boolean status = false;
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            // Set the ID parameter for the prepared statement
            pstmt.setString(1, id);
            // Execute the delete statement and check if any rows were affected
           status = pstmt.executeUpdate()>0; 
  
        } catch (SQLException e) {
            System.err.println("Error deleting customer with ID " + id);
            e.printStackTrace();
        } 
        return status;
    }
    
    //Deletes a seller from the database.
    
    public boolean deleteSeller(String id) {
        String query = "DELETE FROM seller WHERE id = ?";
        boolean status = false;
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
           // Set the ID parameter for the prepared statement
            pstmt.setString(1, id);
           // Execute the delete statement and check if any rows were affected
           status = pstmt.executeUpdate()>0; 
   
        } catch (SQLException e) {
            System.err.println("Error deleting Seller with ID " + id);
            e.printStackTrace();
        } 
        return status;
        
    
    }
    
    }
    

