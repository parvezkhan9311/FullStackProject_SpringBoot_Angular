package com.example.employee.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.management.app.entity.Employee;
import com.example.employee.management.app.repository.EmployeeManagementRepository;

@Service
public class EmployeeManagementService {
	
	@Autowired
	private EmployeeManagementRepository employeeManagementRepository;
	
	public Iterable<Employee> createEmployees(List<Employee> employeeList) {
		 Iterable<Employee> list=employeeManagementRepository.saveAll(employeeList);
		 						return list;
	}

}
