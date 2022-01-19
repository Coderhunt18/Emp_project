package com.hcl.spring.demo.dao;

import com.hcl.spring.demo.models.Employee;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee, Long id);

    Employee deleteEmployeeById(Long id);
}
