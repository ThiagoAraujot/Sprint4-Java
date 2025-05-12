package com.fiap.sprint_java.service;

import com.fiap.sprint_java.domain.supplier.Supplier;
import com.fiap.sprint_java.dto.supplier.SupplierRequestDTO;
import com.fiap.sprint_java.dto.supplier.SupplierResponseDTO;
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

    private SupplierResponseDTO toResponseDTO(Supplier supplier) {
        SupplierResponseDTO dto = new SupplierResponseDTO();

        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setCnpj(supplier.getCnpj());
        dto.setPhone(supplier.getPhone());

        return dto;
    }

    public SupplierResponseDTO save(SupplierRequestDTO data) {
        Supplier newSupplier = new Supplier();

        newSupplier.setName(data.getName());
        newSupplier.setCnpj(data.getCnpj());
        newSupplier.setPhone(data.getPhone());

        supplierRepository.save(newSupplier);

        return toResponseDTO(newSupplier);
    }

    public List<SupplierResponseDTO> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public SupplierResponseDTO findById(UUID id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));

        return toResponseDTO(supplier);
    }

    public SupplierResponseDTO update(String id, SupplierRequestDTO dto) {
        UUID uuid = UUID.fromString(id);
        Supplier supplier = supplierRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));

        supplier.setName(dto.getName());
        supplier.setCnpj(dto.getCnpj());
        supplier.setPhone(dto.getPhone());

        Supplier updatedSupplier = supplierRepository.save(supplier);

        return toResponseDTO(updatedSupplier);
    }

    public void delete(UUID id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));

        supplierRepository.delete(supplier);
    }
}
