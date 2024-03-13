package com.narinder.learnspringsecurity.controller;

import com.narinder.learnspringsecurity.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/vi/students")
public class StudentController {

    private static Integer id = 0;
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(++id, "Narinderpal Singh"),
            new Student(++id, "Harmanpreet Kaur"),
            new Student(++id, "Pargat Singh"),
            new Student(++id, "Aradhna Sharma"),
            new Student(++id, "Aviraj Singh"),
            new Student(++id, "Nimrat kaur"),
            new Student(++id, "Anveer Singh")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student ->
                        student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found with studentId : " + studentId));
    }
}
