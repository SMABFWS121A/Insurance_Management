package com.smabfws121a.martel.breit.insurance.management.data.repository;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Customer;
import com.smabfws121a.martel.breit.insurance.management.data.classes.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("select v from Vehicle v " +
            "where lower(v.marke) like lower(concat('%', :searchTerm, '%'))" +
            "or lower(v.modell) like lower(concat('%', :searchTerm, '%'))" +
            "or lower(v.baujahr) like lower((concat('%', :searchTerm, '%')))")
    List<Vehicle> search(@Param("searchTerm") String searchTerm);

}
