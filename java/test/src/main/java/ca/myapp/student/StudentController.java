package ca.myapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    //private final StudentService studentService;


    //Autowired automatically instantiates student services and injects into parameters
    //@Autowired
    /*public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    */

    //@GetMapping("")
    public List<Student> getStudents(){
        return List.of(new Student());
        //return studentService.getStudents();
    }


}
