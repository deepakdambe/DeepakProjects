package com.employee.EmployeeApplication;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.entity.Project;
import com.employee.EmployeeApplication.entity.Spouse;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Bean
    public CommandLineRunner initialCreate(EmployeeService employeeService) {
        return (args) -> {

            Address address1 = new Address("Line 1", "Line 2", "ZipCode1", "City1", "State1", "Country1");
            Project project1 = new Project("Name1", "Client Name1");
            Spouse spouse1 = new Spouse("Name1", "Mobile1", 30);

            Employee employee = new Employee("Employee1","City1");
            employee.addProject(project1);
            employee.addAddress(address1);
            employee.setSpouse(spouse1);

            employeeService.createEmployee(employee);

            System.out.println("Getting an employee");
            Employee employee1 = employeeService.getAnEmployee(1);

        };
    }
}
