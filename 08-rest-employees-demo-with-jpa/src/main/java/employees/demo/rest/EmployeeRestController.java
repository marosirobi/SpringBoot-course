package employees.demo.rest;

import employees.demo.entity.Employee;
import employees.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;
    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService service, JsonMapper jsonMapper) {
        this.service = service;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable int id){
        Employee emp = service.getById(id);

        if(emp == null){
            throw new RuntimeException("Employee id not found");
        }

        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){
        emp.setId(0);

        return service.save(emp);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        return service.save(emp);
    }

    @PatchMapping("employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String,Object> patchPayload){
        Employee tempEmployee = service.getById(id);

        if(tempEmployee == null){
            throw new RuntimeException("Employee doesnt exists - " + id);
        }

        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed to be in the request body - " + id);
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayload);

        return service.save(patchedEmployee);
    }


    @DeleteMapping("/employees/{id}")
    public String DeleteEmployee(@PathVariable int id){

        Employee emp = service.getById(id);

        if(emp == null){
            throw new RuntimeException("Id is not found - " + id);
        }

        service.deleteById(id);
        return " Deleted employee id - " + id;
    }


}
