package com.example.hotel_reservation.service;

import com.example.hotel_reservation.dto.CustomerRequest;
import com.example.hotel_reservation.model.Customer;
import com.example.hotel_reservation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    // Save a new Customer
    public Customer saveCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setPhone(customerRequest.getPhone());
        return customerRepository.save(customer);
    }

    // Get a Customer by ID
    public Customer getCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    // Update a Customer
    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            return customerRepository.save(existingCustomer);
        } else {
            return null; // If the customer doesn't exist, return null
        }
    }






}
