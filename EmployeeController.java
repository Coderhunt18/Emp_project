package com.hcl.spring.demo.contoller;

import com.hcl.spring.demo.models.Employee;
import com.hcl.spring.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee,id));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
