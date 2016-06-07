package com.hb.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ehc on 30/5/16.
 */
@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column
  private String name;
  @Column
  private String gender;
  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
  private List<Certificates> certificatesList;

  public List<Certificates> getCertificatesList() {
    return certificatesList;
  }

  public void setCertificatesList(List<Certificates> certificatesList) {
    this.certificatesList = certificatesList;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @JsonManagedReference("employee-address")
  @OneToOne(mappedBy = "employee", orphanRemoval = true)
  private Address address;

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
        "id=" + id +
        ", name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        ", address=" + address +
        '}';
  }
}
