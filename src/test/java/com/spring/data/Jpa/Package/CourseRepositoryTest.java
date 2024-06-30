package com.spring.data.Jpa.Package;

import com.spring.data.Jpa.Entity.Course;
import com.spring.data.Jpa.Entity.Student;
import com.spring.data.Jpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAll(){
        List<Course> list =  courseRepository.findAll();
        System.out.println(list);
    }

    @Test
    public void saveCourseWithTeachers(){
        Teacher techer = Teacher.builder()
                .firstName("Vijender")
                .lastName("Singh").build();

        Course course = Course.builder()
                .title("DBMS")
                .credit(3)
                .teacher(techer).build();
        courseRepository.save(course);
    }
    //
    @Test
    public void Pagination(){
//        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,4);

        List<Course> courseList2 = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long noOfPages2 = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        long noOfElements2 = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        System.out.println(courseList2);
        System.out.println(noOfElements2);
        System.out.println(noOfPages2);
    }

    @Test
    public void findBySorting(){
        Pageable sortByTitle = PageRequest.of(
                0,2, Sort.by("title")
        );
        Pageable sortByCreditDesc = PageRequest.of(
                0,2,Sort.by("credit").descending()
        );
        Pageable sortByCreditAndTitle = PageRequest.of(
                0,2,Sort.by("title").and(Sort.by("credit"))
        );
        List<Course> courseList = courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println(courseList);
    }

    @Test
    public void usingJPAforPaging(){
        Pageable pageable = PageRequest.of(0,10);
        List<Course> courseList = courseRepository.findByTitleContaining("DBA",pageable).getContent();
        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher =  Teacher.builder().firstName("Swapnil").lastName("Yadav").build();
        Student student = Student.builder().firstName("Gourvi").lastName("Siriah").emailId("gsiriah1234@gmail.com").build();
        Course course = Course.builder().title("AI").credit(2).teacher(teacher).build();
        course.addStudents(student);
        courseRepository.save(course);
    }

}