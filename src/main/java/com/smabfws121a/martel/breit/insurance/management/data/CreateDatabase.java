package com.smabfws121a.martel.breit.insurance.management.data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

//
//import java.io.FileNotFoundException;
//import java.sql.*;
//
public class CreateDatabase {

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDatabase("abcinsurance.db");
    }
//
//    private CreateDatabase createDB;
//    private ConnectDatabase connection;
//
//    public CreateDatabase() throws SQLException, ClassNotFoundException, FileNotFoundException {
//        // initiate db connection
//        connection = new ConnectDatabase();
//        // create database if it doesn't exist
//        if (connection.checkDB()) {
//            // initiate SQLInterpreter object
//            SQLInterpreter interpreter = new SQLInterpreter();
//            // start process of creating the database
//            interpreter.createDatabase();
//        }
//    }
//
//    protected ConnectDatabase getConnectDatabase() {
//        return this.connection;
//    }
}
