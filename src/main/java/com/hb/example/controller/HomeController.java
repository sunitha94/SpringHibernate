package com.hb.example.controller;

import com.hb.example.dao.EmpoyeeDao;
import com.hb.example.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ehc on 30/5/16.
 */
@Controller
public class HomeController {
  @Autowired
  HomeService homeService;
  @Autowired
  EmpoyeeDao employeeDao;

  @RequestMapping(value = "/")
  public String home() {
    return "index";
  }

  @RequestMapping(value = "/employees")
  public String employeeDetails(Model model) {
    System.out.println(employeeDao.createQuery());
    model.addAttribute("employees", homeService.getAllEmployees());
    return "employees";
  }
  /*@RequestMapping(value ="/employees/{empId}" )
  public String getDetails(@PathVariable(value = "empId") int empId){
    System.out.println(employeeDao.createQuery());
    return "getDetails";
  }*/
}
