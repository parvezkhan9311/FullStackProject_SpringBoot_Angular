package com.example.employee.management.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.management.app.entity.Employee;

@Repository
public interface EmployeeManagementRepository extends CrudRepository<Employee, Integer>{
	

}
