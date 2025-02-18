package com.employeework.service;

import com.employeework.entity.Employee;
import com.employeework.payload.EmployeeDto;
import com.employeework.repostiory.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

//    based on the id I will get the object and get optional object
//    based on the id number i am getting the actual record from the database
    // optional object convert to the employee object using get() method
//Optional<Employee> opEmployee = employeeRepository.findById(id);
//    Employee employee = opEmployee.get(); this is the  actual record coming  from the database
//EmployeeDto dto  <= this is the one that has a record to be updated
//    record is updated use employee.setName(dto.getName) after the update the record then save the record in the database using save() method
    public void updateEmployee(Long id, EmployeeDto dto) {
        Optional<Employee> opEmployee = employeeRepository.findById(id);
        Employee employee = opEmployee.get();
//        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmailId(dto.getEmailId());
        employee.setMobile(dto.getMobile());
        employeeRepository.save(employee);

    }

//    how will get all the employees
//    employeeRepository.findAll()
    public List<Employee> getEmployee() {
       return employeeRepository.findAll();
    }
}
