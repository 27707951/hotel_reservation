package com.example.hotel_reservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static Integer id;

    private String name;
    private String phone;


    public  Customer(Integer id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Customer() {

    }

    public static Integer getId() {
        return id;

    }
    public void setId(Integer id) {
        Customer.id = id;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }
    public String getPhone(){
        return phone;

    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
