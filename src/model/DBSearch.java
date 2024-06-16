/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasandi
 * This class represents the database operations for searching entries to different tables.
 * It has methods to search products, customers, and sellers
 */
public class DBSearch {
    // Database connection URL, username, and password
    private final String url = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private final String user = "root";
    private final String password = "";
    
    /**
     * Searches and retrieves all products from the database.
     * return ResultSet has all products.
     */
    
    static Connection con = null;
    
    public ResultSet SearchAllProducts(){
        
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM products";
            // Establish connection to the database
            con = DriverManager.getConnection(url, user, password);
            
            // Create a statement and execute the query
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }return rs;
    }
    
    /**
     * Searches and retrieves all customers from the database.
     * return ResultSet has all customers.
     */
     public ResultSet SearchAllCustomers(){
       ResultSet rs = null;
       try {
            String query = "SELECT * FROM customer";
         // Establish connection to the database
            con = DriverManager.getConnection(url, user, password);
            
        // Create a statement and execute the query
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }return rs;
     
     
     }
     /**
     * Searches and retrieves all sellers from the database.
     * return ResultSet has all sellers.
     */    
     
     
     public ResultSet SearchAllSellers(){
     ResultSet rs = null;
     
     try {
            String query = "SELECT * FROM seller";
           // Establish connection to the database
            con = DriverManager.getConnection(url, user, password);
            
            // Create a statement and execute the query
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
     
     } return rs;  
    
    
}
     
}
