package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Repository
public interface StudentRepository extends
        JpaRepository<Student, Long> {

    // SELECT * FROM student WHERE email = ?
    //Query is JPQL, not SQL
    @Query("SELECT s FROM Student s WHERE s.email =?1")
    Optional<Student> findStudentsByEmail(String email);

}
