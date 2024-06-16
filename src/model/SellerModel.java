/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
 * This class represents the model for a seller in the system.
 */

public class SellerModel {
    private String id; // Stores the seller's ID
    private String name; // Stores the seller's name
    private String gender; // Stores the seller's gender
    private String password; // Stores the seller's password

    // Default constructor
    public SellerModel() {
        // Default constructor
    }

    // Parameterized constructor
    public SellerModel(String id, String name, String gender, String password) {
        //Assigning the provided values to the relevant fields of the SellerModel object.
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


