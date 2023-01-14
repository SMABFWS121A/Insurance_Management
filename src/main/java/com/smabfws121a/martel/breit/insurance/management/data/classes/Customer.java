package com.smabfws121a.martel.breit.insurance.management.data.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Customer extends AbstractEntity {

    @NotEmpty
    private String vorname;
    @NotEmpty
    private String nachname;
    @NotEmpty
    private String strasse;
    @NotEmpty
    private String hausnr;
    @NotEmpty
    private int plz;
    @NotEmpty
    private String ort;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @NotNull
    @JsonIgnoreProperties({"employees"})
    private Vehicle vehicle;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleName() {
        return vehicle.getBezeichnung();
    }
}
