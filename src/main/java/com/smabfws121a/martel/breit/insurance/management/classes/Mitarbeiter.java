package com.smabfws121a.martel.breit.insurance.management.classes;

//import com.smabfws121a.martel.breit.insurance.management.data.SQLInterpreter;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Mitarbeiter {

    private int pnr;
    private String vorname;
    private String nachname;

    public Mitarbeiter(int pnr, String vorname, String nachname) {
        this.pnr = pnr;
        this.vorname = vorname;
        this.nachname = nachname;
    }

//    protected void writeEmployee() throws SQLException, FileNotFoundException, ClassNotFoundException {
//        SQLInterpreter sql = new SQLInterpreter();
//        sql.write(this);
//    }

    public int getPnr() {
        return this.pnr;
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

}
