package com.smabfws121a.martel.breit.insurance.management.data;

import com.vaadin.flow.component.notification.Notification;
import java.sql.*;

public class connectDatabase {

    private Connection db;
    private static connectDatabase connection;

    /**
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new connectDatabase();
    }**/

    // connect to database
    public connectDatabase() throws ClassNotFoundException, SQLException {

        Notification.show("Trying database connection...");

        // check if desired JDBC driver exists
        //Class.forName(getJdbcdriver());
        // create connector
        //db = DriverManager.getConnection(getDburl() + '/' + getDbname(), getDbuser(), getDbpass());
        //setConnectDatabase();
    }

    public static connectDatabase setConnectDatabase() throws ClassNotFoundException, SQLException {
        connectDatabase db = new connectDatabase();
        Notification.show(db.toString());
        return db;
    }

    // return current connectionDatabase
    public static connectDatabase getConnectDatabase() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            connection = new connectDatabase();
        }
        return connection;
    }

    // return current connection
    public Connection getConnection() {
        return db;
    }
}
