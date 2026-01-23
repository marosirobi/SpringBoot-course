package employees.demo.dao;

import employees.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAll();
    Employee getById(Integer id);
    Employee save(Employee emp);
    void deleteById(Integer id);

}
