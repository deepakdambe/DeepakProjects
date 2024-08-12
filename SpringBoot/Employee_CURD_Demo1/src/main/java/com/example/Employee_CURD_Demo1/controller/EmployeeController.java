package com.example.Employee_CURD_Demo1.controller;

import com.example.Employee_CURD_Demo1.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;


@Controller
@ResponseBody
public class EmployeeController {

    List<Employee> empList;

    public EmployeeController(List<Employee> empList) {
        this.empList = empList;
    }

    public EmployeeController() {
        empList = Arrays.asList(
                new Employee(1, "First Emp"),
                new Employee(2, "Second Emp")
                );
    }

//    @RequestMapping("/empList")
//    public List<Employee> getAllEmplyees() {
//        List<Employee> empList1 = Arrays.asList(
//                new Employee(1, "First Emp"),
//                new Employee(2, "Second Emp")
//        );
//        return empList1;
//    }

    @RequestMapping("/getEmployee")
    public Employee getEmployee() {
        Employee emp = new Employee(1, "Deepak");
        return emp;
    }
}
