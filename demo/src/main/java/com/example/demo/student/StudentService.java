package com.example.demo.student;

//import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Service lets us know that this class needs to be instantiated
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) throws IllegalAccessException {
        Optional<Student> studentByEmail = studentRepository.findStudentsByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalAccessException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    //Transactional puts it in a manage state
    //We don't have to use any queries from the repository
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + "does not exist"));
        if(name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
                student.setEmail(email);
        }
    }
}