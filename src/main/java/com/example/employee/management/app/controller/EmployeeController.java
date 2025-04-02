package com.example.employee.management.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.employee.management.app.entity.Employee;
import com.example.employee.management.app.exception.ResourceNotFoundException;
import com.example.employee.management.app.repository.EmployeeManagementRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired // to inject repository by spring container
	private EmployeeManagementRepository employeeManagementRepository;

	// http://localhost:8080/api/v1/employees
	@GetMapping("/employees")
	public Iterable<Employee> getAllEmployees() {

		return employeeManagementRepository.findAll();
	}

	// http://localhost:8080/api/v1/addEmployee
	// create employee rest API
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {// return the emp object in json format

		return employeeManagementRepository.save(employee);
	}

	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee = employeeManagementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id not exist " + id));
		return ResponseEntity.ok(employee);

	}

	// Update employee rest api

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDet) {
		Employee employee = employeeManagementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id not exist " + id));
		employee.setFirstName(employeeDet.getFirstName());
		employee.setLastName(employeeDet.getLastName());
		employee.setEmailId(employeeDet.getEmailId());

		Employee updatedemployee = employeeManagementRepository.save(employee);
		return ResponseEntity.ok(updatedemployee);

	}
		//delete emplpyee rest api
	
	  @DeleteMapping("/employees/{id}")
	  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
		  Employee employee = employeeManagementRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee with id not exist " + id));
		  employeeManagementRepository.delete(employee);
	  
		  Map<String,Boolean> response=new HashMap<>();
		  response.put("deleted", Boolean.TRUE);
		  return ResponseEntity.ok(response);
	  }
}











