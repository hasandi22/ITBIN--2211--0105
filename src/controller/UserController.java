/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.UserModel;
import view.SelectionView;

/**
 *
 * @author hasandi
 *  Controller class responsible for handling user-related operations
 */
public class UserController {
    private UserModel userModel; //UserModel instance to interact with user data

     // Constructor initializing UserModel
    public UserController() {
        this.userModel = new UserModel();
    }
    // Method to authenticate user
    public boolean authenticateUser(String username, String password) {
        return userModel.authenticate(username, password);// assigns the task of authentication to the UserMode
    }
    
    // Method to login a user and handle UI logic
    public void loginUser(JTextField usernameField, JPasswordField passwordField, javax.swing.JFrame frame) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (authenticateUser(username, password)) {
            JOptionPane.showMessageDialog(frame, "Login successful!");
            new SelectionView().setVisible(true); // Navigate to the admin interface
            frame.dispose(); // Close the login screen
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password.");
            // Clear the text and password fields
            usernameField.setText("");
            passwordField.setText("");
        }
    }
    
    
    // Method to sign up a new user
    public String signUpUser(String username, String password) {
        
        if (password.length() < 8) {
        return "Password should contain at least 8 characters.";
    }
        boolean isSignedUp;
        isSignedUp = userModel.signUp(username, password);
        if (isSignedUp) {
            return "Sign-Up Successful!";
        } else {
            return "Sign-Up Failed. Please try again.";
        }
    }
    
    
}

