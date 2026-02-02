package com.springboot.demo.controller;

import com.springboot.demo.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model){

        model.addAttribute("student",new Student());
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student newStudent){

        System.out.println(newStudent);

        return "student-processform";
    }


}
