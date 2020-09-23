package com.example.demo;

import com.example.demo.entity.StudentEntity;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MabatisLearningApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void daoSelect() {
        System.out.println(userMapper.getAll());
        System.out.println(userMapper.getOne(1));
    }

    @Test
    void daoInsert() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(15);
        studentEntity.setEmail("52125@af.com");
        studentEntity.setName("fanzcbe");
        userMapper.insert(studentEntity.getName(), studentEntity.getEmail(), studentEntity.getAge());
    }

    @Test
    void daoUpdate() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(2);
        studentEntity.setAge(18);
        studentEntity.setEmail("51252125@af.com");
        studentEntity.setName("fazcnzcbe");
        userMapper.update(studentEntity);
    }

    @Test
    void daoDelete() {
//		userMapper.delete(3);
        userMapper.clear();
    }
}
