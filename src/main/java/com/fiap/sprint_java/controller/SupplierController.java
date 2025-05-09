package com.fiap.sprint_java.controller;

import com.fiap.sprint_java.domain.supplier.Supplier;
import com.fiap.sprint_java.domain.supplier.SupplierRequestDTO;
import com.fiap.sprint_java.service.SupplierService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> saveSupplier(@RequestBody SupplierRequestDTO body) {
        Supplier newSupplier = this.supplierService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> findAll() {
        List<Supplier> suppliers = this.supplierService.findAll();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable String id) {
        Supplier supplier = this.supplierService.findById(UUID.fromString(id));

        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable String id, @RequestBody SupplierRequestDTO body) {
        try {
            Supplier updated = supplierService.update(id, body);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable String id) {
        Supplier supplier = this.supplierService.findById(UUID.fromString(id));

        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.supplierService.delete(supplier.getId());

        return ResponseEntity.noContent().build();
    }
}
