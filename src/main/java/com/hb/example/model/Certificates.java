package com.hb.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by ehc on 6/6/16.
 */
@Entity
@Table(name = "certificate")
public class Certificates {
  @Id
  @GeneratedValue
  private int id;
  private String cname;
  @JsonBackReference("employee-certificate")
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "emp_id")
  private Employee employee;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  @Override
  public String toString() {
    return "Certificates{" +
        "id=" + id +
        ", cname='" + cname + '\'' +
        ", employee=" + employee +
        '}';
  }
}

