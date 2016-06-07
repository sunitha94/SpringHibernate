package com.hb.example.repository;

import com.hb.example.model.Certificates;
import com.hb.example.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ehc on 6/6/16.
 */
public interface CertificatesRepository extends CrudRepository<Certificates,String> {
  void deleteByEmployee(Employee employee);
}
