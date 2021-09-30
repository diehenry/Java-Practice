package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService ;

    @GetMapping("/students/{studentId}")
    public Student getById(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }

    @PostMapping("/students")
    public String insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student.getName());
    }

}
