package com.hb.example.dao;

import com.hb.example.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ehc on 30/5/16.
 */
@Transactional
@Component
public class EmpoyeeDao {
  @Autowired
  SessionFactory sessionFactory;

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
   // criteria.add(Restrictions.ilike("name", "s", MatchMode.ANYWHERE));
    return criteria.list();
  }
  public boolean deleteEmployee(int empId)
  {
     Employee employee1=new Employee();
    employee1.setEmpid(empId);
    Session session=sessionFactory.getCurrentSession();
    session.delete(employee1);
    return true;
  }
}
