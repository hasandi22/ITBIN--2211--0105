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
import view.CustomerView;

//controller class responsible for handling customer related operations

public class CustomerController {
    
     // Database connection parameters
    private final String url = "jdbc:mysql://localhost:3306/beauty product shopping system";
    private final String user = "root";
    private final String password = "";

    private CustomerView view; // Added SellerView reference

    // Updated constructor to accept SellerView object
    public CustomerController(CustomerView view) {
        this.view = view;
    }

// Method to retrieve all customers from the database
    public List<CustomerModel> getAllCustomers() {
        List<CustomerModel> customers = new ArrayList<>();
        

        try  {
            ResultSet rs =  new DBSearch().SearchAllCustomers();

            while (rs.next()) {
                CustomerModel customer = new CustomerModel(rs.getString("id"), rs.getString("name"), rs.getString("gender"), rs.getString("password"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

   
 // Method to add a new customer to the database
    public void addCustomer(String id,String name, String gender, String password) {
        CustomerModel customer = new CustomerModel(id, name, gender, password);
        
        DBAdd dbAdd = new DBAdd();
        dbAdd.setView(view); // Set the view in DBAdd
        dbAdd.addCustomer(customer);
        System.out.println("Added successfully");
        /*new DBAdd().addCustomer(customer);
        System.out.println("Added successfully");*/
        
    }
    
    
// Method to update customer in the database
    
    public void updateCustomer(String id, String name, String gender, String password) {
        CustomerModel customer = new CustomerModel(id, name, gender, password);
        new DBUpdate().updateCustomer(customer);
        System.out.println("Updated successfully");
    }

    // Method to delete a customer from the database
    public void deleteCustomer(String id) {
        
            boolean status = new DBDelete().deleteCustomer(id);
            
            
            if (!status) {
                System.err.println("No rows affected. customer ID may not exist: " + id);
            } else {
                System.out.println("Customer with ID " + id + " deleted successfully.");
            }
        
        }
    }



