package com.hb.example.model;

import javax.persistence.*;

/**
 * Created by ehc on 2/6/16.
 */
@Entity
@Table(name = "address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "street")
  private String street;
  @Column(name = "city")
  private String city;
  @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
  @JoinColumn(name = "emp_id")
  private Employee employee;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}
