package com.smabfws121a.martel.breit.insurance.management.service;

import com.smabfws121a.martel.breit.insurance.management.classes.Kunde;
import com.smabfws121a.martel.breit.insurance.management.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlService {

    private final CustomerRepository customerRepository;

    public SqlService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Kunde> findAllCustomers(String filter) {
        if (filter == null || filter.isEmpty()) {
            return customerRepository.findAll();
        } else {
            return customerRepository.search(filter);
        }
    }

    public long countCustomers() {
        return customerRepository.count();
    }

    public void saveCustomer(Kunde customer) {
        if (customer == null) {
            System.err.println("Contact is null.");
            return;
        }
        customerRepository.save(customer);
    }

}
