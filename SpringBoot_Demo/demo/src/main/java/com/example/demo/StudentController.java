package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        studentRepository.save(student);
        return "create" ;
    }

    @PutMapping("/students/{studentId}")
    public String update(@RequestBody Student student,
                         @PathVariable Integer studentId) {

        Student s = studentRepository.findById(studentId).orElse(null);
        if (s != null){
            s.setName(student.getName());
            studentRepository.save(s);
            return "update" ;
        } else {
            return "update failed" ;
        }

    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        studentRepository.deleteById(studentId);
        return "delete" ;
    }

    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId) {

        Student student = studentRepository.findById(studentId).orElse(null);
        return student;
    }

}
