package employees.demo.dao;

import employees.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee emp) {
        Employee dbEmployee = entityManager.merge(emp);
        return dbEmployee;
    }

    @Override
    public void deleteById(Integer id) {
        Employee tempEmp = entityManager.find(Employee.class,id);
        entityManager.remove(tempEmp);
    }
}
