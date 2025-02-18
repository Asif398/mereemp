package com.employeework.repostiory;

import com.employeework.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    this is the marker interface which means this is the empty interface
}