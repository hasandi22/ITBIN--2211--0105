/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
/*
 * This class represents the model for a product in the system.
 */

public class ProductModel {
    private String id; // Stores the Products's ID
    private String name; // Stores the Products's name
    private int quantity; // Stores the Products's quantity
    private double price; // Stores the Products's price
    private String category; // Stores the Products's category

    // Constructors, getters, and setters
    public ProductModel() {}
    
        // Parameterized constructor
    public ProductModel(String id, String name, int quantity, double price, String category) {
        //Assigning the provided values to the relevant fields of the ProductModel object.
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}





