package com.mirza.employeemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirza.employeemanager.model.Department;
import com.mirza.employeemanager.repo.DepartmentRepo;

@Service
public class DepartmentService {
	private final DepartmentRepo departmentRepo;

	@Autowired
	public DepartmentService(DepartmentRepo departmentRepo) {
		this.departmentRepo = departmentRepo;
	}

	public Department addDepartment(Department department) {
		return this.departmentRepo.save(department);
	}
	
	public List<Department> getAllDepartments() {
		return departmentRepo.findAll();
	}
	
	public Department getDepartmentById(Long id) {
		return departmentRepo.getReferenceById(id);
	}
}
