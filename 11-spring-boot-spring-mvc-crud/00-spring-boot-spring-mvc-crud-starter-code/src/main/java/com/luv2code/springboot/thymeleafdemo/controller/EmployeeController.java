package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employees",employeeList);

        return "/employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        model.addAttribute("employee",new Employee());

        return "/employees/add-form";
    }

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("employeeId") int id, Model model) {

        model.addAttribute("employee", employeeService.findById(id));

        return "/employees/add-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee newEmployee){

        employeeService.save(newEmployee);

        return "redirect:/employees/list";
    }


}
