package com.smabfws121a.martel.breit.insurance.management.data;

import java.sql.*;

public class createDatabase {

    public createDatabase() throws SQLException {

        // JDBC driver name and database URL
        final String jdbc_driver = "org.mariadb.jdbc.Driver";
        final String db_url = "jdbc:mariadb://130.61.73.74:27017";

        //  Database credentials
        final String db_user = "abcinsurance";
        final String db_pass = "REDACTED";
        
        // create connection
        Connection abcinsurance = null;

        // connect to database
        try {

            abcinsurance = DriverManager.getConnection(db_url, db_user, db_pass);

        }  catch (SQLException ex) { ex.printStackTrace(); }

    }

}


