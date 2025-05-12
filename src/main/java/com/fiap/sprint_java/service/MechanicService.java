package com.fiap.sprint_java.service;

import com.fiap.sprint_java.domain.mechanic.Mechanic;
import com.fiap.sprint_java.dto.mechanic.MechanicRequestDTO;
import com.fiap.sprint_java.dto.mechanic.MechanicResponseDTO;
import com.fiap.sprint_java.repository.MechanicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    private MechanicResponseDTO toResponseDTO(Mechanic mechanic) {
        MechanicResponseDTO dto = new MechanicResponseDTO();

        dto.setId(mechanic.getId());
        dto.setName(mechanic.getName());
        dto.setAddress(mechanic.getAddress());
        dto.setCnpj(mechanic.getCnpj());
        dto.setPhone(mechanic.getPhone());
        dto.setEmail(mechanic.getEmail());

        return dto;
    }

    public MechanicResponseDTO save(MechanicRequestDTO body) {
        Mechanic newMechanic = new Mechanic();

        newMechanic.setName(body.getName());
        newMechanic.setAddress(body.getAddress());
        newMechanic.setCnpj(body.getCnpj());
        newMechanic.setPhone(body.getPhone());
        newMechanic.setEmail(body.getEmail());

        mechanicRepository.save(newMechanic);

        return toResponseDTO(newMechanic);
    }

    public List<MechanicResponseDTO> findAll() {
        List<Mechanic> mechanics = mechanicRepository.findAll();
        return mechanics.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public MechanicResponseDTO findById(UUID id) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mechanic not found"));

        return toResponseDTO(mechanic);
    }

    public MechanicResponseDTO update(String id, MechanicRequestDTO body) {
        UUID uuid = UUID.fromString(id);

        Mechanic mechanic = mechanicRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Mechanic not found"));

        mechanic.setName(body.getName());
        mechanic.setAddress(body.getAddress());
        mechanic.setCnpj(body.getCnpj());
        mechanic.setPhone(body.getPhone());
        mechanic.setEmail(body.getEmail());

        Mechanic updatedMechanic = mechanicRepository.save(mechanic);

        return toResponseDTO(updatedMechanic);
    }

    public void delete(UUID id) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mechanic not found"));

        mechanicRepository.delete(mechanic);
    }
}
