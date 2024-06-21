package com.spring.data.Jpa.Package;

import com.spring.data.Jpa.Entity.Guardian;
import com.spring.data.Jpa.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.ListResourceBundle;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("singhaldev26@gmail.com")
                .firstName("dev")
                .lastName("singhal")
//                .guardianName("raashi")
//                .guardianMobile("9837075278")
//                .guardianEmail("rashi@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentwithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("sarju")
                .email("surge5@gmail.com")
                .mobile("9837048445")
                .build();

        Student student = Student.builder()
                .emailId("dev@gmail.com")
                .firstName("devu")
                .lastName("singhal")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAll(){
        List<Student> list = studentRepository.findAll();
        System.out.println("Student List " + list);
    }

    @Test
    public void printDev(){
        List<Student> list = studentRepository.findByFirstName("dev");
        System.out.println("Student List " + list);
    }
    @Test
    public void printSinghal(){
        List<Student> list = studentRepository.findByLastName("singhal");
        System.out.println("Student List " + list);
    }

    @Test
    public void printCharContaining(){
        List<Student> list = studentRepository.findByFirstNameContaining("d");
        System.out.println("Student List " + list);
    }

    @Test
    public void printLastNameNotNull(){
        List<Student> list =  studentRepository.findByLastNameNotNull();
        System.out.println(list);
    }

    @Test
    public void printGuardianName(){
        List<Student> list =  studentRepository.findByGuardianName("raashi");
        System.out.println(list);
    }

    @Test
    public void printStudentByEmailId(){
        Student st =  studentRepository.getStudentByEmailAddress("dev@gmail.com");
        System.out.println(st);
    }

    @Test
    public void printStudenNametByEmailId(){
        String st =  studentRepository.getFirstNameByEmailAddress("dev@gmail.com");
        System.out.println(st);
    }
    @Test
    public void printStudenNametByEmailIdNative(){
        Student st =  studentRepository.getStudentByEmail("dev@gmail.com");
        System.out.println(st);
    }

    @Test
    public void printStudenNametByEmailIdNative2(){
        Student st =  studentRepository.getStudentByNativeEmailId("dev@gmail.com");
        System.out.println(st);
    }

    @Test
    public void updateStudentNamebyEmailId(){
        studentRepository.updateFirstNameByEmail("devji","dev@gmail.com");
    }

}