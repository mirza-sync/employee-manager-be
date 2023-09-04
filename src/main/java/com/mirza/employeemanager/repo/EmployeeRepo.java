package com.mirza.employeemanager.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mirza.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Optional<Employee> findEmployeeById(Long id);

	void deleteEmployeeById(Long id);

	@Query(value = "SELECT e.name, d.name FROM employee e LEFT JOIN department d ON e.employee_dept_id = d.id WHERE e.employee_dept_id IS NULL", nativeQuery = true)
	List<Employee> findEmployeesWithoutDepartment();

}
