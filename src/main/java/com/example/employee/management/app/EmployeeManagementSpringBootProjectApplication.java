package com.example.employee.management.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.employee.management.app.entity.Employee;
import com.example.employee.management.app.service.EmployeeManagementService;

@SpringBootApplication
public class EmployeeManagementSpringBootProjectApplication implements CommandLineRunner {

	@Autowired
	private EmployeeManagementService employeeManagementService;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSpringBootProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//createEmployees();
	}

	private void createEmployees() {
		//List<Employee> employeeList=Arrays.asList(new Employee("Parvez", "Khan", "pkparvez@dummy.com"),
												//new Employee("Aafreen", "Khan", "Aafreen@dummy.com"));

		List<Employee> employeeList=Arrays.asList(new Employee("Pkhan", "Pathan", "pkhan123@dummy.com"));
		Iterable<Employee> createEmployee= employeeManagementService.createEmployees(employeeList);
		for(Employee employee:createEmployee) {

			System.out.println(employee);
}
	}

}
