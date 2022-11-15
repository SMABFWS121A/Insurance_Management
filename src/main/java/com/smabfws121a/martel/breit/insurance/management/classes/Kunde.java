package com.smabfws121a.martel.breit.insurance.management.classes;

public class Kunde {

    private int kdnr;
    private String vorname;
    private String nachname;
    private String strasse;
    private String hausnr;
    private int plz;
    private String ort;

    public Kunde(int kdnr, String vorname, String nachname, String strasse, String hausnr, int plz, String ort) {
        this.kdnr = kdnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnr = hausnr;
        this.plz = plz;
        this.ort = ort;
    }
}
