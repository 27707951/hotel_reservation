package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.dto.*;
import com.example.hotel_reservation.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerRequest request) {
        try {
            CustomerResponse customer = customerService.saveCustomer(request);
            return ResponseEntity.ok(customer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
