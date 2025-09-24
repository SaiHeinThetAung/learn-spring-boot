package com.sai.springboot.cruddemo.rest;


import com.sai.springboot.cruddemo.entity.Employee;
import com.sai.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService){
       employeeService=theemployeeService;

    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee=employeeService.findById(id);
        if(employee==null){
            throw new RuntimeException("Employee id not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id){
        employeeService.deleteById(id);
    }
}
