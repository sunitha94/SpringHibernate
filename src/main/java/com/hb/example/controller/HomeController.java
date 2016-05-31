package com.hb.example.controller;

import com.hb.example.dao.EmployeeDao;
import com.hb.example.model.Employee;
import com.hb.example.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
public String employeeForm(Model model){
  model.addAttribute("employee",new Employee());
  return "addEmployee";
}

  @RequestMapping(value = "/employees/add")
  public String addEmployees(Employee employee, Model model) {
    System.out.println(employee);
    model.addAttribute("employees",homeService.createEmployee(employee));
    return "redirect:/employees";
  }
  @RequestMapping(value = "/deleteEmp/{empId}")
  public String deleteEmployee(@PathVariable(value = "empId") int empId, Model model){
    employeeDao.deleteEmployee(empId);
    return "redirect:/employees";
  }
  @RequestMapping(value = "/employees/{empId}")
  public String addEmployee(@PathVariable(value = "empId") int empId, Model model) {
    model.addAttribute("employee", homeService.employeeDetails(empId));
    return "editEmployee";
  }
  @RequestMapping(value = "/employees/update")
  public String updateEmplyees(Employee employee, Model model) {
    employeeDao.updateEmployee(employee);
    return "redirect:/employees";
  }

}

