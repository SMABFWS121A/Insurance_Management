package com.smabfws121a.martel.breit.insurance.management.data.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Fahrzeug extends AbstractEntity {

    @NotEmpty
    private String kennzeichen;
    @NotEmpty
    private String marke;
    private String modell;
    @NotEmpty
    private String versicherungsart;

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
}
