package com.spring.data.Jpa.Entity;

import com.spring.data.Jpa.Package.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRespositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAll(){
        List<Course> list =  courseRepository.findAll();
        System.out.println(list);
    }
}