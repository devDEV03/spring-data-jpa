package com.spring.data.Jpa.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = "teacher","students")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;


    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    @ToString.Exclude
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
            @JoinTable(
                    name = "student_course_map",
                    joinColumns = @JoinColumn(
                            name = "course_id",
                            referencedColumnName = "courseId"
                    ),
                    inverseJoinColumns = @JoinColumn(
                            name = "student_id",
                            referencedColumnName = "studentId"
                    )
            )
    @ToString.Exclude
    private List<Student> students;

    public void addStudents(Student student){
        if(students == null){
            students = new ArrayList<Student>();
        }
        students.add(student);
    }

}

