package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.entity.Project;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First Employee", "Washington"),
            new Employee(2, "Second Employee", "New York")
    ));

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        //return employeeList;
        return employeeRepository.findAll();
    }

    public Employee getAnEmployee(int id) {
        /*return employeeList.stream().filter(e -> (
                e.getEmployeeId() == id)).findFirst().get();*/
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        System.out.println("Fetching Projects in Service class");
        Set<Project> projects = employee.getProjects();
        for (Project p : projects)
            System.out.println(p.getClientName());

        return employee;
    }

    public void createEmployee(Employee employee) {
        //employeeList.add(employee);
        ArrayList<Address> addressArrayList = new ArrayList<>();

        for (Address address : employee.getAddresses()) {
            addressArrayList.add((new Address(address.getLine1(),
                    address.getLine2(),
                    address.getZipCode(),
                    address.getCity(),
                    address.getState(),
                    address.getCountry(), employee)));
        }
        employee.setAddresses(addressArrayList);

        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        /*List<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList){
            if (emp.getEmployeeId() == employee.getEmployeeId()){
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;*/
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        /*ArrayList<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList){
            if(emp.getEmployeeId() == id)
                continue;
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;*/
        employeeRepository.delete(employeeRepository.getById(id));
    }
}
