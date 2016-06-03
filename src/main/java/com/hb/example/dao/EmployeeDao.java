package com.hb.example.dao;

import com.hb.example.model.Address;
import com.hb.example.model.Employee;
import com.hb.example.repository.AddressRepository;
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

  public List createQuery() {
    /*Session session = sessionFactory.getCurrentSession();
    Employee employee = (Employee) session.get(Employee.class, 2);
    employee.setName("suni");*/
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(Employee.class);
    return criteria.list();
  }

  public List emplyeesList() {
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(Employee.class);
    criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
//    criteria.add(Restrictions.ilike("name", "s", MatchMode.ANYWHERE));
    return criteria.list();
  }

  public boolean deleteEmployee(int id) {

    Session session = sessionFactory.getCurrentSession();
    session.delete(employeeRepository.findOne(id));
//    employeeRepository.delete(employee);
    return true;
  }

  public boolean updateEmployee(Employee employee) {
    System.out.println("employee : " + employee);
    Session session = sessionFactory.getCurrentSession();
    Address address = employee.getAddress();
    employee.setAddress(null);
    Employee employee1 = employeeRepository.save(employee);
    address.setEmployee(employee1);
    addressRepository.save(address);
    session.saveOrUpdate(employee);
    return true;
  }

  public List searchEmployees(String name) {
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(Employee.class);
    criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
    criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
    List<Employee> employee = criteria.list();
    return employee;
  }

}
