package com.hcl.spring.demo.dao;

import com.hcl.spring.demo.exception.ResourceNotFoundException;
import com.hcl.spring.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jpa")
public class JpaProvider implements EmployeeDAO {

    @Autowired
    private JpaRepo jpaRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return jpaRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return jpaRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return jpaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id :" + id));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee old = jpaRepo.getById(id);
        old.setFirstName(employee.getFirstName());
        old.setLastName(employee.getLastName());
        old.setEmail(employee.getEmail());
        jpaRepo.save(old);
        return old;
    }

    @Override
    public Employee deleteEmployeeById(Long id) {
        Employee old = jpaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id :" + id));
        jpaRepo.delete(old);
        return old;
    }
}
