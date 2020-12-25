package com.springdatademo.springdatademo.services;

import com.springdatademo.springdatademo.entities.Student;
import com.springdatademo.springdatademo.repositories.StudentsRepository;
import com.springdatademo.springdatademo.services.base.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentsRepository.findAll();
    }

    @Override
    public List<Student> findByNamePattern(String name) {
        return studentsRepository.findAll().stream().filter(student -> student.getName().contains(name))
                .collect(Collectors.toList());
    }
}
