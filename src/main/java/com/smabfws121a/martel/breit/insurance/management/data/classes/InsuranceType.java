package com.smabfws121a.martel.breit.insurance.management.data.classes;

import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class InsuranceType extends AbstractEntity {

//    @NotEmpty
    @Nullable
    private String insuranceType;

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}
