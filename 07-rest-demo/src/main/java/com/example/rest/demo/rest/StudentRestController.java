package com.example.rest.demo.rest;

import com.example.rest.demo.entity.Student;
import com.example.rest.demo.error.StudentErrorResponse;
import com.example.rest.demo.error.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>(
                List.of(
                        new Student("Nina","Nun"),
                        new Student("Tim","Marios"),
                        new Student("Peter","Parker")
                ));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }
    
}
