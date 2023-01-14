package com.smabfws121a.martel.breit.insurance.management.data.service;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Vehicle;
import com.smabfws121a.martel.breit.insurance.management.data.classes.Customer;
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

    public List<Customer> findAllCustomers(String filter) {
        if (filter == null || filter.isEmpty()) {
            return customerRepository.findAll();
        } else {
            return customerRepository.search(filter);
        }
    }

    public long countCustomers() {
        return customerRepository.count();
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public void saveCustomer(Customer customer) {
        if (customer == null) {
            System.err.println("Customer is null.");
            return;
        }
        customerRepository.save(customer);
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> findAllVehicles(String filter) {
        if (filter == null || filter.isEmpty()) {
            return vehicleRepository.findAll();
        } else {
            return vehicleRepository.search(filter);
        }
    }

}
