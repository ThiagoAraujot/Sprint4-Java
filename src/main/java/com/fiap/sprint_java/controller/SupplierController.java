package com.fiap.sprint_java.controller;

import com.fiap.sprint_java.domain.supplier.Supplier;
import com.fiap.sprint_java.dto.supplier.SupplierRequestDTO;
import com.fiap.sprint_java.dto.supplier.SupplierResponseDTO;
import com.fiap.sprint_java.service.SupplierService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDTO> save(@RequestBody SupplierRequestDTO body) {
        SupplierResponseDTO newSupplier = this.supplierService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDTO>> findAll() {
        List<SupplierResponseDTO> suppliers = this.supplierService.findAll();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> findById(@PathVariable String id) {
        SupplierResponseDTO supplier = this.supplierService.findById(UUID.fromString(id));

        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> update(@PathVariable String id, @RequestBody SupplierRequestDTO body) {
        try {
            SupplierResponseDTO updated = supplierService.update(id, body);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> delete(@PathVariable String id) {
        SupplierResponseDTO supplier = this.supplierService.findById(UUID.fromString(id));

        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.supplierService.delete(supplier.getId());

        return ResponseEntity.noContent().build();
    }
}
