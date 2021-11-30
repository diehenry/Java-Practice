package com.example.demo.dao;
import java.sql.SQLException;
import java.util.*;
import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StudentDaoImpl implements StudentDao{

    @Autowired
    @Qualifier("myjdbcJdbcTemplate")
    private NamedParameterJdbcTemplate myjdbcJdbcTemplate;

    @Override
    public List<Student> getByAll() {
        String sql = "SELECT id , name , age FROM student";
        Map<String,Object> map = new HashMap<String,Object>();
        List<Student> list = null ;
        try{
            list = myjdbcJdbcTemplate.query(sql,map,new StudentRowMapper());
        }catch (Exception e){
            e.getMessage();
        }finally {
            return list;
        }

    }

    @Override
    public Student getById(Integer id) {
        String sql = "SELECT id , name , age FROM student WHERE id = :id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);

        List<Student> list = myjdbcJdbcTemplate.query(sql,map,new StudentRowMapper());

        if(list.size() > 0) {
            return list.get(0);
        } else {
            return null ;
        }

    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public String insertStudent(Integer id, String name, Integer age) {
        String sql = "INSERT INTO student(id,name,age) VALUES(:id,:name,:age) ";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        map.put("name",name);
        map.put("age",age);
        String msg = "";
        try{
            myjdbcJdbcTemplate.update(sql,map);
            msg = "{\"msg\":\"添加成功\"}";
        } catch (DataAccessException e){
            msg = "{\"msg\":\"添加失敗: id是唯一值 \"}";
            e.printStackTrace();
        } catch (Exception e){
            msg = "{\"msg\":\"添加失敗: 未知的錯誤 \"}";
            e.printStackTrace();
        } finally {
            return msg;
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public String updateStudent(Integer id ,String name, Integer age, Integer orgId) {
        String sql = "UPDATE student set id=:id , name=:name , age=:age where id=:orgId;";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        map.put("name",name);
        map.put("age",age);
        map.put("orgId",orgId);
        String msg = "";
        try{
            myjdbcJdbcTemplate.update(sql,map);
            msg = "{\"msg\":\"更新成功 \"}";
        } catch (Exception e){
            msg = "{\"msg\":\"更新失敗: 未知的錯誤 \"}";
            e.printStackTrace();
        }finally {
            return msg;
        }


    }

    /*
        @Transactional(rollbackFor = RuntimeException.class)
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
            return "{\"id\":\""+student.getId()+"\",\"name\":\""+student.getName()+"\"}";
    //        return "insert sql id=" + student.getId() + " name=" + student.getName();
        }
    */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public String deleteById(Integer id) {
        String sql = "DELETE FROM student WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        String msg = "";
        try{
            myjdbcJdbcTemplate.update(sql, map);
            msg = "{\"msg\":\"刪除成功 \"}";
        }catch (Exception e){
            msg = "{\"msg\":\"刪除失敗 \"}";
            e.printStackTrace();
        }finally {
            return msg;
        }

    }


}
