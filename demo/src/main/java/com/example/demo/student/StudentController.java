package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;


    //Autowired automatically instantiates student services and injects into parameters
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("")
    public List<Student> getStudents(){
        //return List.of(new Student());
        return studentService.getStudents();
        /*return List.of(new Student(1L,
                "Mariam",
                "Mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5),
                21
        ));

         */
    }


}