package com.mirza.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirza.employeemanager.model.Department;
import com.mirza.employeemanager.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		Department newDepartment = departmentService.addDepartment(department);
		return new ResponseEntity<>(newDepartment, HttpStatus.OK);
	}
}
