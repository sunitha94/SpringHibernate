package com.hb.example.formbeans;

import com.hb.example.model.Address;

/**
 * Created by ehc on 6/6/16.
 */
public class Employee {
  private String name;
  private String gender;
  private String cname;
  private Address address;

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        ", cname='" + cname + '\'' +
        ", address=" + address +
        '}';
  }
}
