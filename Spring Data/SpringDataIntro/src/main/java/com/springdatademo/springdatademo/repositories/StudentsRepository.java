package com.springdatademo.springdatademo.repositories;

import com.springdatademo.springdatademo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);
}
