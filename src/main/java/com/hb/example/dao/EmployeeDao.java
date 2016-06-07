package com.hb.example.dao;

import com.hb.example.model.Address;
import com.hb.example.model.Certificates;
import com.hb.example.model.Employee;
import com.hb.example.repository.AddressRepository;
import com.hb.example.repository.CertificatesRepository;
import com.hb.example.repository.EmployeeRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ehc on 30/5/16.
 */
@Transactional
@Component
public class EmployeeDao {
  @Autowired
  SessionFactory sessionFactory;
  @Autowired
  EmployeeRepository employeeRepository;
  @Autowired
  AddressRepository addressRepository;
  @Autowired
  CertificatesRepository certificatesRepository;

  public List createQuery() {
    /*Session session = sessionFactory.getCurrentSession();
    Employee employee = (Employee) session.get(Employee.class, 2);
    employee.setName("suni");*/
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(Employee.class);
    return criteria.list();
  }

  public List<Employee> emplyeesList() {
    Session session = sessionFactory.openSession();
    Criteria criteria = session.createCriteria(Employee.class);
    criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
    //criteria.add(Restrictions.ilike("name", "s", MatchMode.ANYWHERE));
    List<Employee> employeeList = criteria.list();
    session.close();
    return employeeList;
  }

  public boolean deleteEmployee(int id) {

   /* Session session = sessionFactory.openSession();
    session.delete(employeeRepository.findOne(id));
    session.close();*/
    Employee employee = new Employee();
    employee.setId(id);
    certificatesRepository.deleteByEmployee(employee);
    employeeRepository.delete(employee);
    return true;
  }

  public boolean updateEmployee(com.hb.example.formbeans.Employee employee) {
    System.out.println("employee : " + employee);
    Session session = sessionFactory.getCurrentSession();
    Employee employee1 = new Employee();
    employee1.setName(employee.getName());
    employee1.setGender(employee.getGender());
    Employee savedEmployee = employeeRepository.save(employee1);
    Certificates certificates = new Certificates();
    certificates.setCname(employee.getCname());
    certificates.setEmployee(savedEmployee);
    certificatesRepository.save(certificates);
    Address address = employee.getAddress();
    address.setEmployee(savedEmployee);
    addressRepository.save(address);
    session.saveOrUpdate(savedEmployee);
    return true;
  }

  public List searchEmployees(String name) {
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(Employee.class);
    criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
    //criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
    List<Employee> employee = criteria.list();
    return employee;
  }

  public boolean createEmployee(com.hb.example.formbeans.Employee employee) {
    Employee employee1 = new Employee();
    employee1.setName(employee.getName());
    employee1.setGender(employee.getGender());
    Employee savedEmployee = employeeRepository.save(employee1);
    Certificates certificates = new Certificates();
    certificates.setCname(employee.getCname());
    certificates.setEmployee(savedEmployee);
    certificatesRepository.save(certificates);
    Address address = employee.getAddress();
    address.setEmployee(savedEmployee);
    addressRepository.save(address);
    System.out.println(employee);
    return true;
  }


}
