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
 * This class represents the database operations for updating entries to different tables.
 * It has methods to update products, customers, and sellers.
 */
public class DBUpdate {
    // Database connection URL, username, and password
    private final String url = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private final String user = "root";
    private final String password = "";
    
    //Updates a product in the database.
    //seller model has the updated product details
    public void updateProduct(ProductModel product) {
        String query = "UPDATE products SET name = ?, quantity = ?, price = ?, category = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            // Setting  parameters for the prepared statement
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getCategory());
            pstmt.setString(5, product.getId());
            // Execute the update statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Updates a customer in the database.
    //seller model has the updated customer details
    public void updateCustomer(CustomerModel customer) {
        String query = "UPDATE customer SET name = ?, gender = ?, password = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            // Setting  parameters for the prepared statement
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getGender());
            pstmt.setString(3, customer.getPassword());
            pstmt.setString(4, customer.getId());
            // Execute the update statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Updates a seller in the database.
    //seller model has the updated seller details
    public void updateSeller(SellerModel seller) {
        String query = "UPDATE seller SET name = ?, gender = ?, password = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
            // Setting  parameters for the prepared statement
            pstmt.setString(1, seller.getName());
            pstmt.setString(2, seller.getGender());
            pstmt.setString(3, seller.getPassword());
            pstmt.setString(4, seller.getId());
            // Execute the update statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
