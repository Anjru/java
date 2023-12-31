package ca.myapp.student;

//import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//Service lets us know that this class needs to be instantiated
//@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(new Student(1L,
                "Mariam",
                "Mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5),
                21
        ));
    }
}
