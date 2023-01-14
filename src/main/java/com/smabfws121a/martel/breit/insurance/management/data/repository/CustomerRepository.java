package com.smabfws121a.martel.breit.insurance.management.data.repository;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c " +
            "where lower(c.vorname) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.nachname) like lower(concat('%', :searchTerm, '%'))")
    List<Customer> search(@Param("searchTerm") String searchTerm);
}
