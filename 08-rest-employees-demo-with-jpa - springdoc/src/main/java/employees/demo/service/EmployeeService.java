package employees.demo.service;

import employees.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();
    Employee getById(Integer id);
    Employee save(Employee emp);
    void deleteById(Integer id);
}
