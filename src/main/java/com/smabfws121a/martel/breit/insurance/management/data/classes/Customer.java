package com.smabfws121a.martel.breit.insurance.management.data.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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
    private String plz;
    @NotEmpty
    private String ort;
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    @NotNull
    @JsonIgnoreProperties({"employees"})
    private Vehicle vehicle;
    @OneToOne
    @JoinColumn(name = "registration_plate_id")
    @NotNull
    private RegistrationPlate registrationPlate;
    @ManyToOne
    @JoinColumn(name = "insurance_type_id")
    @NotNull
    private InsuranceType insuranceType;

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

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
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

    public void setVehicle(Vehicle vehicles) {
        this.vehicle = vehicles;
    }

    public RegistrationPlate getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(RegistrationPlate registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }
}
