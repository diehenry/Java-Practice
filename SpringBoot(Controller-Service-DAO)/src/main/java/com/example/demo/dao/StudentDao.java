package com.example.demo.dao;
import com.example.demo.Student;
import org.springframework.stereotype.Component;


public interface StudentDao {

    Student getById(Integer studentId) ;

    String insertStudent(String name);
}
