package com.hb.example.model;

import javax.persistence.*;

/**
 * Created by ehc on 30/5/16.
 */
@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int empid;
  @Column
  private String name;

  public int getEmpid() {
    return empid;
  }

  public void setEmpid(int empid) {
    this.empid = empid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "empid=" + empid +
        ", name='" + name + '\'' +
        '}';
  }
}
