package com.smabfws121a.martel.breit.insurance.management.classes;

import javax.persistence.Entity;

@Entity
public class Fahrzeug extends AbstractEntity {

    private String kennzeichen;
    private String marke;
    private String modell;
    private String versicherungsart;
    private Kunde halter;



}
