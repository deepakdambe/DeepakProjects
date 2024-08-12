package com.example.demo1.service;

import com.example.demo1.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> elist = new ArrayList<> ( Arrays.asList(
            new Employee(1, "Deepak", "Rajapur"),
            new Employee(2, "Sampada", "Ratnagiri")
    ));

    public List<Employee> getEmployeeList()
    {
        return elist;
    }

    public Employee getEmployeeByID(int id)
    {
        for (Employee employee : elist) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void createEmployee(Employee employee)
    {
        elist.add(employee);
    }

    public void updateEmployee(int id, Employee employee)
    {
        for (Employee emp : elist) {
            if (emp.getId() == id) {
                emp.setCity(employee.getCity());
                emp.setName(employee.getName());
            }
        }
    }

    public void deleteEmployee(int id) {
        for (Employee emp : elist) {
            if (emp.getId() == id) {
                elist.remove(emp);
                break;
            }
        }
    }
}
