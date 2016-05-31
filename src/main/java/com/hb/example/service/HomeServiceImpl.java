package com.hb.example.service;

import com.hb.example.model.Employee;
import com.hb.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ehc on 30/5/16.
 */
@Component
public class HomeServiceImpl implements  HomeService {
  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public Iterable<Employee> getAllEmployees() {

    return employeeRepository.findAll();
  }
  public boolean createEmployee(Employee employee)
  {

    employeeRepository.save(employee);
    return  true;
  }
  public Employee employeeDetails(int empId)
  {
    return employeeRepository.findOne(empId);
  }
}

