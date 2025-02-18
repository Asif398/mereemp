package com.employeework.controller;

import com.employeework.entity.Employee;
import com.employeework.payload.EmployeeDto;
import com.employeework.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
  private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//    I create url when i click on sent then is json vai this url will come to the backend code
//backend code will extracrt the jjson content and that json content it is save it to database
//    http://localhost:8080/api/v1/employee/addEmployee this is url calling the method
//    postman extract the json object with the help of @RequestBody
//    @PostMapping("/addEmployee")
//   public String addEmployee(
//
//  ){
//    return "hello";//its return back hello in the postman
//   }

//    @PostMapping("/addEmployee")
//    public String addEmployee(
//  @RequestBody Employee employee
//    ){
//       System.out.println(employee.getName());// when I click url the send in the postman then all data in the backend console show
//        System.out.println(employee.getEmailId());// this url is capable of supplying the json object to the backend code directly
//        System.out.println(employee.getMobile());
//        return "hello";//its return back hello in the postman
//    }

    @PostMapping("/addEmployee")
    public String addEmployee(
            @RequestBody Employee employee
    ){
        employeeService.addEmployee(employee);
        return "saved";
    }

//    http://localhost:8080/api/v1/employee?id=1 this is the query parameter based on id then delete
//    this the second api this api can take the id number as input and it can delete the record in the backend
//    this url is an api because this is an interface to which the frontend framework will get connected angular react android app get connected the api

    @DeleteMapping
    public String deleteEmployee(
            @RequestParam Long id
    ){
        employeeService.deleteEmployee(id);
        return "deleted";
    }

    //update the record based on id number and also requestBody
    //    http://localhost:8080/api/v1/employee?id=1 @RequestBody Employee employee <= i would supply to this the data to be updated in this requestbody object called employee
    // based on id number this record should be updated ,but the data to be updated is present here =>"employee"
    //but i will not take the data into this Employee entity class , rather I will created a dto that is good practise
    // create a another pacakages called as payload

    //EmployeeDto this EmployeeDto i will use for receving the data from the postman and the data is about updating a record
     //EmployeeDto and Employee entity class have same field
    @PutMapping
    public String updateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto
    ){
        employeeService.updateEmployee(id,dto);
        return "updated";
    }
//    read all the data , this getEmployee will return back list of employee object called List<Employee>, return type aslo will List of Employee object List<Employee>
    @GetMapping
    public List<Employee> getEmployee(

    ){
     List<Employee> employees=  employeeService.getEmployee();
        return employees;
    }


}
