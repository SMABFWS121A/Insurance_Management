package com.smabfws121a.martel.breit.insurance.management.data.service;

import com.smabfws121a.martel.breit.insurance.management.data.classes.InsuranceType;
import com.smabfws121a.martel.breit.insurance.management.data.classes.RegistrationPlate;
import com.smabfws121a.martel.breit.insurance.management.data.classes.Vehicle;
import com.smabfws121a.martel.breit.insurance.management.data.classes.Customer;
import com.smabfws121a.martel.breit.insurance.management.data.repository.CustomerRepository;
import com.smabfws121a.martel.breit.insurance.management.data.repository.InsuranceTypeRepository;
import com.smabfws121a.martel.breit.insurance.management.data.repository.RegistrationPlateRepository;
import com.smabfws121a.martel.breit.insurance.management.data.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlService {

    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    private final InsuranceTypeRepository insuranceTypeRepository;
    private final RegistrationPlateRepository registrationPlateRepository;

    public SqlService(CustomerRepository customerRepository, VehicleRepository vehicleRepository, InsuranceTypeRepository insuranceTypeRepository, RegistrationPlateRepository registrationPlateRepository) {
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
        this.insuranceTypeRepository = insuranceTypeRepository;
        this.registrationPlateRepository = registrationPlateRepository;
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

    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    public void saveVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            System.err.println("Vehicle is null.");
            return;
        }
        vehicleRepository.save(vehicle);
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

    public List<InsuranceType> findAllInsuranceTypes() {
        return insuranceTypeRepository.findAll();
    }

    public List<RegistrationPlate> findAllRegistrationPlates() {
        return registrationPlateRepository.findAll();
    }

//    public RegistrationPlate getRegistrationPlate() {
//        return registrationPlate;
//    }
//
//    public String getRegistrationPlateString() {
//        return registrationPlate.getRegistrationPlate();
//    }
}
