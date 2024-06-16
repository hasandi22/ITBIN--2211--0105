/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author himas
 */


import model.ProductModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DBAdd;
import model.DBDelete;
import model.DBSearch;
import model.DBUpdate;

//controller class responsible for handling product related operations

public class ProductController {
   // Database connection parameters
    private final String url = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private final String user = "root";
    private final String password = "";

    // Method to retrieve all products from the database
    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<>();
        
        try  {
            ResultSet rs =  new DBSearch().SearchAllProducts();

            while (rs.next()) {
                ProductModel product = new ProductModel( rs.getString("id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("category"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    
// Method to add a new product to the database
    public void addProduct(String id, String name, int quantity, double price, String category) {
        ProductModel product = new ProductModel();
        product.setId(id);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setCategory(category);
        new DBAdd().addProduct(product);
    }

    

// Method to update product in the database
    public void updateProduct(String id, String name, int quantity, double price, String category) {
        ProductModel product = new ProductModel(id, name, quantity, price, category);
        new DBUpdate().updateProduct(product);
    }
    
// Method to delete a product from the database
    public void deleteProduct(String id) {
           boolean status = new DBDelete().deleteProduct(id);

        
            if (!status) {
                System.err.println("No rows affected. Product ID may not exist: " + id);
            } else {
                System.out.println("Product with ID " + id + " deleted successfully.");
            }
        
        }
    }

   



