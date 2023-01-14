package com.smabfws121a.martel.breit.insurance.management.data.classes;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vehicle extends AbstractEntity {

    @NotEmpty
    private String kennzeichen;
    @NotEmpty
    private String marke;
    @NotEmpty
    private String modell;
    @NotEmpty
    private String versicherungsart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Nullable
    private Customer customer;

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getVersicherungsart() {
        return versicherungsart;
    }

    public void setVersicherungsart(String versicherungsart) {
        this.versicherungsart = versicherungsart;
    }

    public String getBezeichnung() {
        return marke + " " + modell;
    }

    @Nullable
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(@Nullable Customer customer) {
        this.customer = customer;
    }
}
