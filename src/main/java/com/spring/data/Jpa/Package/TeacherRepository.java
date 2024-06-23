package com.spring.data.Jpa.Package;

import com.spring.data.Jpa.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
