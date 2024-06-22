package com.spring.data.Jpa.Package;

import com.spring.data.Jpa.Entity.Course;
import com.spring.data.Jpa.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest{

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course
                .builder()
                .title("english")
                .credit(2)
                .build();

        CourseMaterial cm = CourseMaterial
                .builder()
                .course(course)
                .url("dev")
                .build();

        courseMaterialRepository.save(cm);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> list = courseMaterialRepository.findAll();
        System.out.println(list);
    }
}