package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private static final List<Student> studentList = Arrays.asList(
            new Student(1, "Vin"),
            new Student(2, "Bao"),
            new Student(3, "Bee")
    );

    @GetMapping(path = "{studentID}")
    public Student getStudent(@PathVariable ("studentID") Integer studentID) {
        return studentList.stream()
                .filter(student -> studentID.equals(student.getStudentID()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentID + " does not exists"));
    }
}
