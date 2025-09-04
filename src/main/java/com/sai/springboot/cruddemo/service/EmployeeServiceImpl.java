package com.sai.springboot.cruddemo.service;

import com.sai.springboot.cruddemo.entity.Employee;
import com.sai.springboot.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
        employeeRepository = theemployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()) {
            employee=result.get();
        }
        else {
            throw new RuntimeException("id not found -"+id);
        }
        return employee;
    }


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteById(int theId) {
    employeeRepository.deleteById(theId);
    }
}
