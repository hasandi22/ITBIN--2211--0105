/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.SellerModel;
import view.SellerView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.CustomerModel;
import model.DBAdd;
import model.DBDelete;
import model.DBSearch;
import model.DBUpdate;

//controller class responsible for handling seller related operations
public class SellerController {
    
     // Database connection parameters
    private final String url = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private final String user = "root";
    private final String password = "";

    private SellerView view; // Added SellerView reference

    // Updated constructor to accept SellerView object
    public SellerController(SellerView view) {
        this.view = view;
    }

    public List<SellerModel> getAllSellers() {
        List<SellerModel> sellers = new ArrayList<>();
        

        try  {
            ResultSet rs =  new DBSearch().SearchAllSellers();

            while (rs.next()) {
                SellerModel seller = new SellerModel(rs.getString("id"), rs.getString("name"), rs.getString("gender"), rs.getString("password"));
                sellers.add(seller);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sellers;
    }

    
 // Method to add a new seller to the database
    public void addSeller(String id, String name, String gender, String password) {
        SellerModel seller = new SellerModel(id, name, gender, password);
        DBAdd dbAdd = new DBAdd();
        dbAdd.setView(view); // Set the view in DBAdd
        dbAdd.addSeller(seller);
        System.out.println("Added successfully");
        
        
    }

    
// Method to update seller in the database
    public void updateSeller(String id, String name, String gender, String password) {
        SellerModel seller = new SellerModel(id, name, gender, password);
        new DBUpdate().updateSeller(seller);
        System.out.println("Updated successfully");
    }
// Method to delete a seller from the database
    public void deleteSeller(String id) {
        boolean status = new DBDelete().deleteSeller(id);

     
            
            if (!status) {
                System.err.println("No rows affected. Seller ID may not exist: " + id);
            } else {
                System.out.println("Seller with ID " + id + " deleted successfully.");
                view.clearFields();
            } 
        
        }
    }


