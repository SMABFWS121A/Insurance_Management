package com.smabfws121a.martel.breit.insurance.management.data.classes;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class RegistrationPlate extends AbstractEntity {

    @NotEmpty
    private String registrationPlate;

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }
}
