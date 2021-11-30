package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao ;

    @Override
    public List<Student> getByAll() {
        return studentDao.getByAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public String insertStudent(Integer id,String name,Integer age) {
        return studentDao.insertStudent(id,name,age);
    }

    @Override
    public String deleteById(Integer id) {
        return studentDao.deleteById(id);
    }

    @Override
    public String updateStudent(Integer id, String name, Integer age, Integer orgId) {

        String msg = (studentDao.getById(id) != null) ?
                ((id == orgId) ? studentDao.updateStudent(id, name, age, orgId) : "{\"msg\":\"更新失敗: id已經存在了! \"}")
                : studentDao.updateStudent(id, name, age, orgId);
        return msg;
    }


}
