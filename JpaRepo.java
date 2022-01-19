package com.hcl.spring.demo.dao;

import com.hcl.spring.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<Employee, Long> {
}
