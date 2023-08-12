package com.mirza.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirza.employeemanager.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
