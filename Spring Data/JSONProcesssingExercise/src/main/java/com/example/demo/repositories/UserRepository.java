package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u INNER JOIN Product p ON p.seller.id = u.id WHERE p.buyer IS NOT NULL " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findBySoldProducts();
}
