package model;

import exception.PasswordLengthException;
import exception.UsernameLengthException;

import java.io.Serializable;

//Represents a login combination with a username, password and website
public class Combination implements Serializable {
    private String username;
    private String password;
    private String website;

    //EFFECTS: constructs a combination with a given username, password, and website
    // throws UsernameLengthException if the username provided is 0 characters
    // and throws PasswordLengthException if the password provided is 0 characters
    public Combination(String username, String password, String website)
            throws UsernameLengthException, PasswordLengthException {
        if (username.length() == 0) {
            throw new UsernameLengthException();
        }
        if (password.length() == 0) {
            throw new PasswordLengthException();
        }
        this.username = username;
        this.password = password;
        this.website = website;
    }

    //EFFECTS: returns the username
    public String getUsername() {
        return username;
    }

    //EFFECTS: returns the password
    public String getPassword() {
        return password;
    }

    //EFFECTS: returns the website
    public String getWebsite() {
        return website;
    }

    //EFFECTS: prints the combination into string format
    public String toString() {
        return "Username: " + username + " Password: " + password + " URL: " + website;
    }

    //MODIFIES: this
    //EFFECTS: changes the username
    public void setUsername(String user) {
        username = user;
    }

    //MODIFIES: this
    //EFFECTS: changes the password
    public void setPassword(String pw) {
        password = pw;
    }

    //MODIFIES: this
    //EFFECTS: changes the website
    public void setWebsite(String url) {
        website = url;
    }
}
