package com.smabfws121a.martel.breit.insurance.management.data;

import com.smabfws121a.martel.breit.insurance.management.classes.*;
import java.io.FileNotFoundException;
import java.sql.*;

public class SQLInterpreter {

    private String sqlStatement;
    private ConnectDatabase connection = new ConnectDatabase();

    public SQLInterpreter() throws SQLException, FileNotFoundException, ClassNotFoundException {

    }
    public SQLInterpreter(String sqlStatement) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.sqlStatement = sqlStatement;
    }

    protected void createDatabase() throws SQLException {
        // create SQL statement object
        Statement sql = connection.getConnection().createStatement();

        // create database specified in dbconfig.yaml
        sql.execute("CREATE DATABASE " + connection.getConnectionDBname());
    }

    private void checkMitarbeiter() {

    }

    private void checkPassword() {

    }

    private void writeUser(Benutzer user) {

    }
}
