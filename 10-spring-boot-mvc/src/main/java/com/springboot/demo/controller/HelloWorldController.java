package com.springboot.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {



    @GetMapping("/showForm")
    public String showForm(){

        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){

        return "helloworld";
    }

    @RequestMapping("/processFormTwo")
    public String letsShout(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName").toUpperCase();

        String message = "Hey " + name + "!!!!!";

        model.addAttribute("message", message);

        return "helloworld";
    }

    @PostMapping("/processFormThree")
    public String letsShout(@RequestParam("studentName") String name, Model model){

        name = name.toUpperCase();

        String message = "Hey " + name + "!!!!!";

        model.addAttribute("message", message);

        return "helloworld";
    }


}
