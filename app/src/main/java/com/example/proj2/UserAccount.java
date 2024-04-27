package com.example.proj2; // Package declaration indicating the location of the class

/**
 * The UserAccount class represents a user's account information.
 * It stores the user's email ID, password, and Firebase UID (user identification token).
 */
public class UserAccount {
    private String emailId; // Private field to store the user's email ID
    private String password; // Private field to store the user's password
    private String idToken; // Private field to store the Firebase UID (user identification token)

    /**
     * Constructs a new UserAccount object with default values.
     */
    public UserAccount() {}

    /**
     * Retrieves the Firebase UID (user identification token) associated with this user account.
     *
     * @return The Firebase UID (user identification token)
     */
    public String getIdToken() {
        return idToken;
    }


    /**
     * Sets the Firebase UID (user identification token) for this user account.
     *
     * @param idToken The Firebase UID (user identification token) to set
     */
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    /**
     * Retrieves the email ID associated with this user account.
     *
     * @return The email ID
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email ID for this user account.
     *
     * @param emailId The email ID to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Sets the password for this user account.
     *
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the password associated with this user account.
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }
}
