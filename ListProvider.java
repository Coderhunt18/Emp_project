package com.hcl.spring.demo.dao;

import com.hcl.spring.demo.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("list")
public class ListProvider implements EmployeeDAO {

    private Long id=0L;
    private List<Employee> employees = new ArrayList<Employee>();

    @Override
    public List<Employee> getAllEmployees() { return employees; }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setId(id++);
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employees.stream().filter(e->id.equals(e.getId())).findFirst().orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee old = employees.stream().filter(e->id.equals(e.getId())).findFirst().orElse(null);
        if (old!=null) {
            old.setEmail(employee.getEmail());
            old.setFirstName(employee.getFirstName());
            old.setLastName(employee.getLastName());
        }
        return old;
    }

    @Override
    public Employee deleteEmployeeById(Long id) {
        Employee old = employees.stream().filter(e->id.equals(e.getId())).findFirst().orElse(null);
        if (old!=null) {
            employees.remove(old);
        }
        return old;
    }
}
