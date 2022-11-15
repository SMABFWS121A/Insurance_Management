package com.smabfws121a.martel.breit.insurance.management.classes;

import com.smabfws121a.martel.breit.insurance.management.data.SQLInterpreter;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Benutzer {

    private String benutzername;
    private String passwort;
    private String salt;

    public Benutzer(String benutzername, String passwort) {
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.salt = BCrypt.gensalt(16);

        // remove plaintext password and replace it with a hashed one
        this.hashPassword();
    }

    // genrate hashed password based on the users plaintext password and the generated salt
    private void hashPassword() {
        this.passwort = BCrypt.hashpw(this.passwort, this.salt);
    }

    private void writeUser() {

    }

}
