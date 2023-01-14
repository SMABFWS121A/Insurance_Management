package com.smabfws121a.martel.breit.insurance.management.data.repository;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Kunde, Long> {

    @Query("select c from Kunde c " +
            "where lower(c.vorname) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.nachname) like lower(concat('%', :searchTerm, '%'))")
    List<Kunde> search(@Param("searchTerm") String searchTerm);
}
