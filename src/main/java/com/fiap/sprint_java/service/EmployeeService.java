package com.fiap.sprint_java.service;

import com.fiap.sprint_java.domain.employee.Employee;
import com.fiap.sprint_java.domain.employee.EmployeeRequestDTO;
import com.fiap.sprint_java.domain.employee.EmployeeResponseDTO;
import com.fiap.sprint_java.domain.mechanic.Mechanic;
import com.fiap.sprint_java.repository.EmployeeRepository;
import com.fiap.sprint_java.repository.MechanicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MechanicRepository mechanicRepository;

    public EmployeeService(EmployeeRepository employeeRepository, MechanicRepository mechanicRepository) {
        this.employeeRepository = employeeRepository;
        this.mechanicRepository = mechanicRepository;
    }

    // Method to convert Employee entity to EmployeeResponseDTO
    private EmployeeResponseDTO toResponseDTO(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setPhone(employee.getPhone());
        dto.setEmail(employee.getEmail());
        dto.setRole(employee.getRole());
        dto.setCpf(employee.getCpf());
        dto.setMechanic(employee.getMechanic());
        return dto;
    }

    public EmployeeResponseDTO save(EmployeeRequestDTO body) {
        Mechanic mechanic = mechanicRepository.findById(body.getMechanicId())
                .orElseThrow(() -> new EntityNotFoundException("Mechanic not found"));

        Employee newEmployee = new Employee();

        newEmployee.setName(body.getName());
        newEmployee.setPhone(body.getPhone());
        newEmployee.setEmail(body.getEmail());
        newEmployee.setRole(body.getRole());
        newEmployee.setCpf(body.getCpf());
        newEmployee.setMechanic(mechanic);

        Employee savedEmployee = employeeRepository.save(newEmployee);

        return toResponseDTO(savedEmployee);
    }

    public List<EmployeeResponseDTO> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public EmployeeResponseDTO findById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        return toResponseDTO(employee);
    }

    public EmployeeResponseDTO update(String id, EmployeeRequestDTO body) {
        Employee employee = employeeRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        Mechanic mechanic = mechanicRepository.findById(body.getMechanicId())
                .orElseThrow(() -> new EntityNotFoundException("Mechanic not found"));

        employee.setName(body.getName());
        employee.setPhone(body.getPhone());
        employee.setEmail(body.getEmail());
        employee.setRole(body.getRole());
        employee.setCpf(body.getCpf());
        employee.setMechanic(mechanic);

        Employee updatedEmployee = employeeRepository.save(employee);
        return toResponseDTO(updatedEmployee);
    }

    public void delete(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }
}
