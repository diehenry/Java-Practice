package com.example.demo.dao;
import java.util.*;
import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class StudentDaoImpl implements StudentDao{

    @Autowired
    @Qualifier("myjdbcJdbcTemplate")
    private NamedParameterJdbcTemplate myjdbcJdbcTemplate;

    @Override
    public Student getById(Integer studentId) {

        String sql = "SELECT id , name FROM student WHERE id = :studentId";
        Map<String,Object> map = new HashMap<>();
        map.put("studentId",studentId);

        List<Student> list = myjdbcJdbcTemplate.query(sql,map,new StudentRowMapper());

        if(list.size() > 0) {
            return list.get(0);
        } else {
            return null ;
        }

    }

    @Override
    public String insertStudent(String name) {
        String sql = "INSERT INTO student(name) VALUES(:name) ";
        Map<String , Object> map = new HashMap<>();
        map.put("name",name);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        myjdbcJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int id = keyHolder.getKey().intValue();
        Student student = new Student();
        student.setId(id);
        student.setName(name);

        return "insert sql id=" + student.getId() + ", name=" + student.getName();
    }
}
