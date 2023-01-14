package com.smabfws121a.martel.breit.insurance.management.data.classes;

//import com.smabfws121a.martel.breit.insurance.management.data.SQLInterpreter;

import javax.persistence.Entity;

@Entity
public class Mitarbeiter extends AbstractEntity {

    private int pnr;
    private String vorname;
    private String nachname;

    public int getPnr() {
        return pnr;
    }

    public void setPnr(int pnr) {
        this.pnr = pnr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
