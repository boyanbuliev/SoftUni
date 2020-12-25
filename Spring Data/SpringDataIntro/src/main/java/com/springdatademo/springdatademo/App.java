package com.springdatademo.springdatademo;

import com.springdatademo.springdatademo.entities.Student;
import com.springdatademo.springdatademo.services.base.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App implements CommandLineRunner {
    @Autowired
    private StudentsService studentsService;

    @Override
    public void run(String... args) throws Exception {
        studentsService.getAll().forEach(System.out::println);


    }
}
