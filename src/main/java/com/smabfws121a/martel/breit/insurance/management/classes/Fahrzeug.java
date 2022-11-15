package com.smabfws121a.martel.breit.insurance.management.classes;

public class Fahrzeug {

    private String kennzeichen;
    private String marke;
    private String modell;
    private String versicherungsart;
    private Kunde halter;

    public Fahrzeug(String kennzeichen, String marke, String modell, String versicherungsart, Kunde halter) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.modell = modell;
        this.versicherungsart = versicherungsart;
        this.halter = halter;
    }
}
