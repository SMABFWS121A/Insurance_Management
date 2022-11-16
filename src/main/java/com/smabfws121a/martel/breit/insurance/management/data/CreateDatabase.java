package com.smabfws121a.martel.breit.insurance.management.data;

import java.io.FileNotFoundException;
import java.sql.*;

public class CreateDatabase {

    private CreateDatabase createDB;
    private ConnectDatabase connection;

    public CreateDatabase() throws SQLException, ClassNotFoundException, FileNotFoundException {
        // initiate db connection
        connection = new ConnectDatabase();
        // create database if it doesn't exist
        if (connection.checkDB()) {
            // initiate SQLInterpreter object
            SQLInterpreter interpreter = new SQLInterpreter();
            // start process of creating the database
            interpreter.createDatabase();
        }
    }

    protected ConnectDatabase getConnectDatabase() {
        return this.connection;
    }
}


