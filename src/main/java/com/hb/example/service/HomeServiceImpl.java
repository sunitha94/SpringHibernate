package com.hb.example.service;

import com.hb.example.model.Address;
import com.hb.example.model.Employee;
import com.hb.example.repository.AddressRepository;
import com.hb.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ehc on 30/5/16.
 */
@Component
@Transactional
public class HomeServiceImpl implements HomeService {
  @Autowired
  EmployeeRepository employeeRepository;
  @Autowired
  AddressRepository addressRepository;

  @Override
  public Iterable<Employee> getAllEmployees() {

    return employeeRepository.findAll();
  }

  public boolean createEmployee(Employee employee) {
    Address address = employee.getAddress();
    employee.setAddress(null);
    Employee employee1 = employeeRepository.save(employee);
    address.setEmployee(employee1);
    addressRepository.save(address);
    return true;
  }
  public Employee employeeDetails(int Id) {
    return employeeRepository.findOne(Id);
  }
 /* public List searchEmployees(String city)
  {
    return  addressRepository.findByCity(city);
  }
*/
}

