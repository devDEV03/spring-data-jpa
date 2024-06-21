package com.spring.data.Jpa.Package;

import com.spring.data.Jpa.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String name);
    public List<Student> findByLastName(String lastName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String name);

    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getFirstNameByEmailAddress(String email);

    @Query(
            value = "select * from table_stdt s where s.email_id = ?1",
            nativeQuery = true
    )
    Student getStudentByEmail(String email);

    @Query(
            value = "select * from table_stdt s where s.email_id = :emailId",
            nativeQuery = true
    )
    Student getStudentByNativeEmailId(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update table_stdt set first_name = ?1 where email_id = ?2",
            nativeQuery = true
    )
    int updateFirstNameByEmail(String first_name,String emailId);
}
