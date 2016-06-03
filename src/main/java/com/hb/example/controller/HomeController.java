package com.hb.example.controller;

import com.hb.example.dao.EmployeeDao;
import com.hb.example.model.Address;
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
    model.addAttribute("employees", employeeDao.emplyeesList());
    return "employees";
  }

  @RequestMapping(value = "/addEmployee")
  public String employeeForm(Model model) {
    model.addAttribute("employee", new Employee());
    return "addEmployee";
  }

  @RequestMapping(value = "/employees/add")
  public String addEmployees(Employee employee, Address address, Model model) {
    System.out.println(employee);
    System.out.println(employee.getAddress());
    model.addAttribute("employees", homeService.createEmployee(employee));
    return "redirect:/employees";
  }

  @RequestMapping(value = "/deleteEmp/{Id}")
  public String deleteEmployee(@PathVariable(value = "Id") int Id, Model model) {
    employeeDao.deleteEmployee(Id);
    return "redirect:/employees";
  }

  @RequestMapping(value = "/employees/{Id}")
  public String editEmployee(@PathVariable(value = "Id") int Id, Model model) {
    model.addAttribute("employee", homeService.employeeDetails(Id));
    return "editEmployee";
  }

  @RequestMapping(value = "/employees/update")
  public String updateEmplyees(Employee employee, Address address, Model model) {
    employeeDao.updateEmployee(employee);
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

