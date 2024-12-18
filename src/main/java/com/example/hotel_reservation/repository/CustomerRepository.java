package com.example.hotel_reservation.repository;
import com.example.hotel_reservation.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // 查詢客戶資料 (根據 ID)
    @Query("SELECT c FROM Customer c WHERE c.ID = :id")
    Customer findCustomerById(@Param("id") Integer id);

    // 更新客戶資料
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.name = :name, c.phone = :phone WHERE c.ID = :id")
    void updateCustomer(@Param("id") Integer id, @Param("name") String name, @Param("phone") String phone);

    Optional<Customer> findByNameAndPhone(String name, String phone);

}

