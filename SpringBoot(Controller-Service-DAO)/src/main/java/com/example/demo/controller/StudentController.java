package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService ;

    @GetMapping("/students")
    public List<Student> getByAll(){
        return studentService.getByAll();
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @PostMapping("/students")
    public String insertStudent(@RequestBody @Valid Student student) {
        return studentService.insertStudent(student.getId(),
                student.getName(),student.getAge());
    }

    @DeleteMapping("/students/{id}")
    public String deleteById(@PathVariable Integer id){
        return studentService.deleteById(id);
    }

    @PutMapping("/students/{id}")
    public String updateStudentById(@RequestBody @Valid Student student,
                                    @PathVariable(name="id") Integer orgId){
        return studentService.updateStudent(student.getId(),
                student.getName(),student.getAge(),orgId);
    }

}
