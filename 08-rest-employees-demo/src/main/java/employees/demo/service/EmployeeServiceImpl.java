package employees.demo.service;

import employees.demo.dao.EmployeeDAO;
import employees.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDAO.getById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee emp) {
        return employeeDAO.save(emp);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeDAO.deleteById(id);
    }
}
