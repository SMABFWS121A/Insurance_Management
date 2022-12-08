package com.smabfws121a.martel.breit.insurance.management.classes;

import com.smabfws121a.martel.breit.insurance.management.data.SQLInterpreter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Benutzer {

    private String benutzername;
    private String passwort;
    private String salt;
    private String role;

    public Benutzer(String benutzername, String passwort, String role) {
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.role = role;

        // generate salt value for user
        this.salt = BCrypt.gensalt(16);

        // remove plaintext password and replace it with a hashed one
        this.hashPassword();
    }

    // generate hashed password based on the users plaintext password and the generated salt
    private void hashPassword() {
        this.passwort = BCrypt.hashpw(this.passwort, this.salt);
    }

    private void writeUser() throws SQLException, FileNotFoundException, ClassNotFoundException {

    }

    protected boolean isEmployee() {
        return false;
    }

    protected boolean isCustomer() {
        return false;
    }

    public String getBenutzername() {
        return this.benutzername;
    }

    public String getPasswort() {
        return this.passwort;
    }

    public String getRole() {
        return this.role;
    }

}
