package employees.demo.dao;

import employees.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

                                                    //entity type,  primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
