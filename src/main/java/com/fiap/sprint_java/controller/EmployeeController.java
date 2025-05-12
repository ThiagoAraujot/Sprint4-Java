package com.fiap.sprint_java.controller;

import com.fiap.sprint_java.domain.employee.EmployeeRequestDTO;
import com.fiap.sprint_java.domain.employee.EmployeeResponseDTO;
import com.fiap.sprint_java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> save(@RequestBody EmployeeRequestDTO body) {
        EmployeeResponseDTO employee = this.employeeService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> findAll() {
        List<EmployeeResponseDTO> employees = this.employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable String id) {
        EmployeeResponseDTO employee = this.employeeService.findById(UUID.fromString(id));

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@PathVariable String id, @RequestBody EmployeeRequestDTO body) {
        EmployeeResponseDTO employee = this.employeeService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        EmployeeResponseDTO employee = this.employeeService.findById(UUID.fromString(id));

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.employeeService.delete(employee.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
