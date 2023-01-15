package com.smabfws121a.martel.breit.insurance.management.data.classes;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class InsuranceType extends AbstractEntity {

    @NotEmpty
    private String insuranceType;

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}
