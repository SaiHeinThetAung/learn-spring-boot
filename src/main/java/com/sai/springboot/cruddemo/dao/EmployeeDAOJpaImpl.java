package com.sai.springboot.cruddemo.dao;

import com.sai.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager em;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> query = em.createQuery("from Employee ", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {

        //get employee
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //save employee
        Employee dbEmployee=em.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee employee = em.find(Employee.class, theId);
        em.remove(employee);
    }
}
