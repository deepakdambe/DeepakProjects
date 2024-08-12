package com.example.demo1.controller;

import com.example.demo1.entity.Employee;
import com.example.demo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getEmployeeList()
    {
       return employeeService.getEmployeeList();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployeeByID(@PathVariable int id)
    {
        return employeeService.getEmployeeByID(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee)
    {
        employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void createEmployee(@PathVariable int id, @RequestBody Employee employee)
    {
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
    }
}
