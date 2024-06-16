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
import view.CustomerView;
import view.SellerView;

/**
 *
 * @author hasandi
 * This class represents the database operations for adding entries to different tables.
 * It has methods to add products, customers, and sellers
 */
public class DBAdd {
    // Database connection URL, username, and password
    private final String url = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private final String user = "root";
    private final String password = "";

   // Method to add a product to the database 
    public void addProduct(ProductModel product) {
        String query = "INSERT INTO products (id, name, quantity, price, category) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setString(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setDouble(4, product.getPrice());
            pstmt.setString(5, product.getCategory());
            // Execute the update statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     private CustomerView view; // Added CustomerView reference
     
     // Updated constructor to accept CustomerView object
     public void setView(CustomerView view) {
        this.view = view;}
     
     //method to add a customer to the database
     public void addCustomer(CustomerModel customer) {
        
        String query = "INSERT INTO customer (id, name, gender, password) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setString(1, customer.getId());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getGender());
            pstmt.setString(4, customer.getPassword());
            // Execute the update statement
            pstmt.executeUpdate();
            
            if (view != null) {
                view.loadCustomer(); // Assuming loadCustomer() updates the JTable
            } else {
                System.err.println("View is not initialized.");
            }
            // After adding a seller to the database, update the JTable and refresh it
            view.loadCustomer(); // Assuming loadCUstomer() updates the JTable
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     private SellerView view1; // Added SellerView reference

   // Updated constructor to accept SellerView object
   public void setView(SellerView view) {
        this.view1 = view;}
   
   //method to add a seller to the database
    public void addSeller(SellerModel seller){
        String query = "INSERT INTO seller (id, name, gender, password) VALUES (?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setString(1, seller.getId());
            pstmt.setString(2, seller.getName());
            pstmt.setString(3, seller.getGender());
            pstmt.setString(4, seller.getPassword());
            // Execute the update statement
            pstmt.executeUpdate();

            // After adding a seller to the database, update the JTable and refresh it
            view1.loadSeller(); // Assuming loadSeller() updates the JTable
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    
}
