package com.spring.data.Jpa.Package;

import com.spring.data.Jpa.Entity.Course;
import com.spring.data.Jpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeachers(){
        Course courseDSA = Course
                .builder()
                .credit(2)
                .title("DBA")
                .build();

        Course courseJava = Course
                .builder()
                .credit(6)
                .title("Java")
                .build();

        Teacher teacher = Teacher
                .builder()
                .firstName("Dev")
                .lastName("Singhal")
                .course(List.of(courseJava,courseDSA))
                .build();

        teacherRepository.save(teacher);
    }
}