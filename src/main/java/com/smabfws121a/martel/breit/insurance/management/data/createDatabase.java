package com.smabfws121a.martel.breit.insurance.management.data;

import com.vaadin.flow.component.notification.Notification;

import java.sql.*;

public class createDatabase extends connectDatabase {

    private static createDatabase connection;

    public createDatabase(Connection connectDB) throws SQLException, ClassNotFoundException {
        // initiate db connection
        connectDatabase dbConnect = getConnectDatabase();
        Connection db = getConnection();
        // create database if it doesn't exist
        //if (!checkDB(getDbname())) {
        //    String sql = "CREATE DATABASE abcinsurance";
        //    Statement sqlStatement = db.createStatement();

        //    sqlStatement.execute(sql);
        //    Notification.show("Database created successfully...");
        //} else {
        //    Notification.show("Database already exists...");
        //}
    }

    /** check if database exists
     * @param dbName : name of database
     * @return : database with the given param dbName exists (true) or doesn't exist (false)
     */
    private boolean checkDB(String dbName) {

        try {
            // open up connection
            Notification.show("Creating database connection...");
            Connection db = getConnection();

            // set up results
            ResultSet databases = db.getMetaData().getCatalogs();

            //iterate through results and check for the desired db name
            while (databases.next()) {
                String databaseName = databases.getString(1);
                if (databaseName.equals(dbName)) {
                    // database exists
                    return true;
                }
            }
        }
        // exception handling
        catch (Exception e) {
            Notification.show("Error while creating database...");
            e.printStackTrace();
        }
        // database doesn't exist
        return false;
    }

    protected createDatabase setCreateDatabase() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            connection = new createDatabase(getConnection());
        }
        return connection;
    }

}


