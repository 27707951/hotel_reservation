package com.example.hotel_reservation.repository;
import com.example.hotel_reservation.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
