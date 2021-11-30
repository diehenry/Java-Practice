package com.example.demo.dao;
import com.example.demo.Student;
import java.util.*;
import org.springframework.stereotype.Component;


public interface StudentDao {

    List<Student> getByAll();

    Student getById(Integer id);

    String insertStudent(Integer id,String name,Integer age);

    String deleteById(Integer id);

    String updateStudent(Integer id,String name,Integer age,Integer orgId);

}
