package com.smabfws121a.martel.breit.insurance.management.data;

import com.vaadin.flow.component.notification.Notification;
import java.io.FileNotFoundException;
import java.sql.*;

public class ConnectDatabase {

    private Connection connection;
    private Connector connector = new Connector();

    // connect to database
    public ConnectDatabase() throws ClassNotFoundException, SQLException, FileNotFoundException {

        // check if desired JDBC driver exists
        Class.forName(connector.getJDBCdriver());

        // create database connection
        connection = DriverManager.getConnection(connector.getDBurl() + '/' + connector.getDBname(), connector.getDBuser(), connector.getDBpass());
    }

    public static ConnectDatabase setConnectDatabase() throws ClassNotFoundException, SQLException, FileNotFoundException {
        ConnectDatabase db = new ConnectDatabase();
        Notification.show(db.toString());
        return db;
    }

    protected ResultSet getConnectionDBlist() throws SQLException {
        return connection.getMetaData().getCatalogs();
    }

    protected String getConnectionDBname() {
        return connector.getDBname();
    }

    protected Connection getConnection() {
        return this.connection;
    }

    protected Connector getConnector() {
        return this.connector;
    }

    /** check if database exists
     * @return : database for the given connection exists (true) or doesn't exist (false)
     */
    protected boolean checkDB() throws SQLException {

        // receive databases
        ResultSet databases = this.getConnectionDBlist();

        //iterate through results and check for the desired db name
        while (databases.next()) {
            String databaseName = databases.getString(1);
            if (databaseName.equals(this.getConnectionDBname())) {
                // database exists
                return true;
            }
        }
        // database does not exist
        return false;
    }
}
