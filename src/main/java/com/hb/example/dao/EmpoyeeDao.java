package com.hb.example.dao;

import com.hb.example.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ehc on 30/5/16.
 */
@Transactional
@Component
public class EmpoyeeDao {
  @Autowired
  SessionFactory sessionFactory;
  public Employee createQuery() {
    Session session = sessionFactory.getCurrentSession();
    Employee employee = (Employee) session.get(Employee.class, 1);
    employee.setName("xyz");
    session=sessionFactory.getCurrentSession();
    session.save(employee);
    session=sessionFactory.getCurrentSession();
    Criteria criteria=
   return employee;
  }

}
