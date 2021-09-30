package com.example.demo.service;

import com.example.demo.Student;
import org.springframework.stereotype.Component;


public interface StudentService {
    Student getById(Integer studentId);

    String insertStudent(String name);
}
