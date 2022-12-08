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
        // user table
        sql.execute("CREATE TABLE abc_users");
        // employee table
        sql.execute("CREATE TABLE abc_empoyees");
        // customer table
        sql.execute("CREATE TABLE abc_customers");
    }

    public void checkMitarbeiter() throws SQLException {
        // create SQL statement object
        Statement sql = connection.getConnection().createStatement();

        //
    }

    public boolean checkPassword(Benutzer user) throws SQLException {

        // create SQL statement object
        Statement sql = connection.getConnection().createStatement();

        // get user from db
        ResultSet result = sql.executeQuery("SELECT * FROM abc_users WHERE benutzername = "+ user.getBenutzername());

        // double check correct username
        if(user.getBenutzername().equals(result.getString("benutzername"))) {
            // check password hash
            if(user.getPasswort().equals(result.getString("passwort"))) {
                return true;
            }
        }
        return false;
    }

    public void write(Benutzer user) throws SQLException {
        // create SQL statement object
        Statement sql = connection.getConnection().createStatement();

        // write to db
        sql.execute("INSERT INTO abc_user VALUES(" + user.getBenutzername() + "," + user.getPasswort() +
                user.getRole() + ");");
    }

    public void write(Mitarbeiter employee) throws SQLException {
        // create SQL statement object
        Statement sql = connection.getConnection().createStatement();

        // write to db
        sql.execute("INSERT INTO abc_employees VALUES(" + employee.getPnr() + "," + employee.getVorname() + "," +
                employee.getNachname() + ");");
    }
}
