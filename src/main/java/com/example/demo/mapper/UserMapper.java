package com.example.demo.mapper;

import com.example.demo.entity.StudentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * from student")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age")
    })
    List<StudentEntity> getAll();

    @Select("SELECT * from student WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age")
    })
    StudentEntity getOne(long id);

//    @Insert("INSERT INTO student(name,email,age) VALUES(#{name},#{email},#{age})")
//    void insert(StudentEntity studentEntity);

    @Insert("INSERT INTO student(name,email,age) VALUES(#{name},#{email},#{age})")
    void insert(String name, String email, int age);

    @Update("UPDATE student SET name=#{name},email=#{email},age=#{age} WHERE id =#{id}")
    void update(StudentEntity studentEntity);

    @Delete("DELETE FROM student WHERE id =#{id}")
    void delete(long id);

    @Delete("truncate student;")
    void clear();
}
