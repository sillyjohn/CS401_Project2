package com.example.proj2; // Package declaration indicating the location of the class

public class UserAccount {
    private String emailId; // Private field to store the user's email ID
    private String password; // Private field to store the user's password
    private String idToken; // Private field to store the Firebase UID (user identification token)

    // Default constructor
    public UserAccount() {}

    // Getter method for retrieving the Firebase UID
    public String getIdToken() {
        return idToken;
    }

    // Setter method for setting the Firebase UID
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    // Getter method for retrieving the user's email ID
    public String getEmailId() {
        return emailId;
    }

    // Setter method for setting the user's email ID
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    // Setter method for setting the user's password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter method for retrieving the user's password
    public String getPassword() {
        return password;
    }
}
