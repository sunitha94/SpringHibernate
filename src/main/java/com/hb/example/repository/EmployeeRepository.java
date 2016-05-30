package com.hb.example.repository;

import com.hb.example.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ehc on 30/5/16.
 */
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
}
