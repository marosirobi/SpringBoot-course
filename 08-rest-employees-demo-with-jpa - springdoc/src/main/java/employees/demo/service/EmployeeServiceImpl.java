package employees.demo.service;

import employees.demo.dao.EmployeeRepository;
import employees.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        Optional<Employee> result = employeeRepo.findById(id);
        Employee tempEmp = null;

        if(result.isPresent()){
            tempEmp = result.get();
        }else{
            throw new RuntimeException("Did not find the id employee - " + id);
        }

        return tempEmp;
    }

    @Override
    @Transactional
    public Employee save(Employee emp) {
        return employeeRepo.save(emp);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeRepo.deleteById(id);
    }
}
