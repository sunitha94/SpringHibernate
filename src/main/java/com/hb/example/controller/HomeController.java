package com.hb.example.controller;

import com.hb.example.dao.EmployeeDao;
import com.hb.example.model.Address;
import com.hb.example.model.Certificates;
import com.hb.example.model.Employee;
import com.hb.example.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ehc on 30/5/16.
 */

@Controller
public class HomeController {
  @Autowired
 HomeService homeService;
  @Autowired
  EmployeeDao employeeDao;

  @RequestMapping(value = "/")
  public String home() {
    return "index";
  }

  @RequestMapping(value = "/employees")
  public String employeeDetails(Model model) {
// System.out.println("certificates: " + employeeDao.emplyeesList().get(0).getCertificatesList());
    model.addAttribute("employees", employeeDao.emplyeesList());
    return "employees";
  }

  @RequestMapping(value = "/addEmployee")
  public String employeeForm(Model model) {
    model.addAttribute("employee", new com.hb.example.formbeans.Employee());
    return "addEmployee";
  }

  @RequestMapping(value = "/employees/add")
  public String addEmployees(com.hb.example.formbeans.Employee employee, Address address, Certificates certificates, Model model) {
    System.out.println(employee);
    System.out.println(employee.getAddress());
    model.addAttribute("employees", employeeDao.createEmployee(employee));
    return "redirect:/employees";
  }

  @RequestMapping(value = "/deleteEmp/{Id}")
  public String deleteEmployee(@PathVariable(value = "Id") int Id, Model model) {
    employeeDao.deleteEmployee(Id);
    return "redirect:/employees";
  }

  @RequestMapping(value = "/employees/{Id}")
  public String editEmployee(@PathVariable(value = "Id") int Id, Model model) {
    Employee employee=homeService.employeeDetails(Id);
    com.hb.example.formbeans.Employee employee1=new com.hb.example.formbeans.Employee();
    employee1.setCname(employee.getName());
    employee1.setGender(employee.getGender());
    employee1.setName(employee.getName());
    employee1.setAddress(employee.getAddress());
    model.addAttribute("employee",employee1);
    return "editEmployee";
  }

  @RequestMapping(value = "/employees/update")
  public String updateEmplyees(com.hb.example.formbeans.Employee employee, Address address,Model model) {
    employeeDao.updateEmployee(employee);
System.out.println(employee);
    return "redirect:/employees";
}

  @RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List searchEmployee(@RequestParam(value = "name") String name) {
    /*System.out.println("city: " + city);
    System.out.println("employeName: "+homeService.searchEmployees(city).get(0).getEmployee().getName());
    return homeService.searchEmployees(city);*/
    return employeeDao.searchEmployees(name);
  }
}

