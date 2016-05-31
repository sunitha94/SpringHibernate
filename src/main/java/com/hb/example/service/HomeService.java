package com.hb.example.service;

import com.hb.example.model.Employee;

/**
 * Created by ehc on 30/5/16.
 */
public interface HomeService {
 Iterable<Employee> getAllEmployees();
  boolean createEmployee(Employee employee);
}
