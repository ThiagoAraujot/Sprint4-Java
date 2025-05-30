package com.fiap.sprint_java.repository;

import com.fiap.sprint_java.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
