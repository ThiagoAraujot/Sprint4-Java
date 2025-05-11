package com.fiap.sprint_java.controller;

import com.fiap.sprint_java.domain.customer.CustomerRequestDTO;
import com.fiap.sprint_java.domain.customer.CustomerResponseDTO;
import com.fiap.sprint_java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> save(@RequestBody CustomerRequestDTO body) {
        CustomerResponseDTO customer = this.customerService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAll() {
        List<CustomerResponseDTO> customers = this.customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable String id) {
        CustomerResponseDTO customer = this.customerService.findById(UUID.fromString(id));

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@PathVariable String id, @RequestBody CustomerRequestDTO body) {
        CustomerResponseDTO customer = this.customerService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        CustomerResponseDTO customer = this.customerService.findById(UUID.fromString(id));

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.customerService.delete(customer.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
