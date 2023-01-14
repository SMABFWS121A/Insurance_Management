package com.smabfws121a.martel.breit.insurance.management.data.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Kunde extends AbstractEntity {

    @NotEmpty private String vorname;
    @NotEmpty private String nachname;
    @NotEmpty private String strasse;
    @NotEmpty private String hausnr;
    @NotEmpty private int plz;
    @NotEmpty private String ort;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @NotNull
    @JsonIgnoreProperties({"employees"})
    private Fahrzeug vehicle;

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

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnr() {
        return hausnr;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Fahrzeug getVehicle() {
        return vehicle;
    }

    public void setVehicle(Fahrzeug vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleName() {
        return vehicle.getBezeichnung();
    }
}
