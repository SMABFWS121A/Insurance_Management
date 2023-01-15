//package com.smabfws121a.martel.breit.insurance.management.data.classes;
//
//import org.springframework.security.crypto.bcrypt.BCrypt;
//
//import javax.persistence.Entity;
//
//@Entity
//public class User extends AbstractEntity {
//
//    private String username;
//    private String password;
//    private String salt;
//    private String role;
//
//
//    public User() {}
//
//    public User(String username, String password, String role) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//
//        this.salt = BCrypt.gensalt(16);
//        this.hashPassword();
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPasswort() {
//        return this.password;
//    }
//
//    public String getSalt() {
//        return this.salt;
//    }
//
//    public String getRole() {
//        return this.role;
//    }
//
//    /**
//     * generate hashed password based on the users plaintext password and the generated salt
//      */
//    private void hashPassword() {
//        this.password = BCrypt.hashpw(this.password, this.salt);
//    }
//}
