package com.example.demo.service;

import com.example.demo.Student;
import org.springframework.stereotype.Component;

import java.util.*;


public interface StudentService {

    List<Student> getByAll();

    Student getById(Integer id);

    String insertStudent(Integer id,String name,Integer age);

    String deleteById(Integer id);

    String updateStudent(Integer id,String name,Integer age,Integer orgId);

}
