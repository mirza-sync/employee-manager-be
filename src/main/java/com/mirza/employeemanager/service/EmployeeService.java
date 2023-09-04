package com.mirza.employeemanager.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirza.employeemanager.exception.UserNotFoundException;
import com.mirza.employeemanager.model.Employee;
import com.mirza.employeemanager.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User of id " + id + " not found"));
	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	
	public List<Employee> findEmployeesWithoutDepartment() {
		return employeeRepo.findEmployeesWithoutDepartment();
	}
}
