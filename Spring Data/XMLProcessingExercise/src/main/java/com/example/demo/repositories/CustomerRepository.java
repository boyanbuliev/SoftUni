package com.example.demo.repositories;

import com.example.demo.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNameAndBirthDate(String name, LocalDateTime birthDate);

    @Query("SELECT c FROM Customer c ORDER BY c.birthDate, c.youngDriver")
    List<Customer> findAllByBirthDateAndIsYoungDriver();
}
