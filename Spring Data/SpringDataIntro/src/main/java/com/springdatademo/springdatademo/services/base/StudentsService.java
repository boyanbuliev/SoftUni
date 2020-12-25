package com.springdatademo.springdatademo.services.base;

import com.springdatademo.springdatademo.entities.Student;

import java.util.List;

public interface StudentsService {
    List<Student> getAll();

    List<Student> findByNamePattern(String name);
}
