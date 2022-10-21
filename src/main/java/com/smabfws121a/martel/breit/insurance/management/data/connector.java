package com.smabfws121a.martel.breit.insurance.management.data;

// will serve as a negotiater between the frontend and the backend
public class connector {

    // JDBC driver name and database information
    private static final String jdbcdriver = "org.mariadb.jdbc.Driver";
    private static final String dburl = "jdbc:mariadb://130.61.73.74:27017";
    private static final String dbname = "abcinsurance";

    //  Database credentials
    private static final String dbuser = "abcinsurance";
    private static final String dbpass = "v*yC]/mDdXSSD1Er";

    protected String getJdbcdriver() {
        return jdbcdriver;
    }

    protected String getDburl() {
        return dburl;
    }

    protected String getDbname() {
        return dbname;
    }

    protected String getDbuser() {
        return dbuser;
    }

    protected String getDbpass() {
        return dbpass;
    }
}
