package com.fiap.sprint_java.service;

import com.fiap.sprint_java.domain.supplier.Supplier;
import com.fiap.sprint_java.domain.supplier.SupplierRequestDTO;
import com.fiap.sprint_java.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier save(SupplierRequestDTO data) {
        Supplier newSupplier = new Supplier();

        newSupplier.setName(data.name());
        newSupplier.setCnpj(data.cnpj());
        newSupplier.setPhone(data.phone());

        supplierRepository.save(newSupplier);

        return newSupplier;
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(UUID id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier update(String id, SupplierRequestDTO dto) {
        UUID uuid = UUID.fromString(id);
        Supplier supplier = supplierRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));

        supplier.setName(dto.name());
        supplier.setCnpj(dto.cnpj());
        supplier.setPhone(dto.phone());

        return supplierRepository.save(supplier);
    }

    public void delete(UUID id) {
        supplierRepository.deleteById(id);
    }
}
