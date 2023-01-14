package com.smabfws121a.martel.breit.insurance.management.data.service;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Fahrzeug;
import com.smabfws121a.martel.breit.insurance.management.data.classes.Kunde;
import com.smabfws121a.martel.breit.insurance.management.data.repository.CustomerRepository;
import com.smabfws121a.martel.breit.insurance.management.data.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlService {

    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;

    public SqlService(CustomerRepository customerRepository, VehicleRepository vehicleRepository) {
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
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

    public void deleteCustomer(Kunde customer) {
        customerRepository.delete(customer);
    }

    public void saveCustomer(Kunde customer) {
        if (customer == null) {
            System.err.println("Customer is null.");
            return;
        }
        customerRepository.save(customer);
    }

    public List<Fahrzeug> findAllVehicles() {
        return vehicleRepository.findAll();
    }

}
