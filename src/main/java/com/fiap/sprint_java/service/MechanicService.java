package com.fiap.sprint_java.service;


import com.fiap.sprint_java.domain.mechanic.Mechanic;
import com.fiap.sprint_java.domain.mechanic.MechanicRequestDTO;
import com.fiap.sprint_java.repository.MechanicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    public Mechanic save(MechanicRequestDTO body) {
        Mechanic newMechanic = new Mechanic();

        newMechanic.setName(body.getName());
        newMechanic.setAddress(body.getAddress());
        newMechanic.setCnpj(body.getCnpj());
        newMechanic.setPhone(body.getPhone());
        newMechanic.setEmail(body.getEmail());

        mechanicRepository.save(newMechanic);

        return newMechanic;
    }

    public List<Mechanic> findAll() {
        return mechanicRepository.findAll();
    }

    public Mechanic findById(UUID id) {return mechanicRepository.findById(id).orElse(null);}

    public Mechanic update(String id, MechanicRequestDTO body) {
        UUID uuid = UUID.fromString(id);

        Mechanic mechanic = mechanicRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Mechanic not found"));

        mechanic.setName(body.getName());
        mechanic.setAddress(body.getAddress());
        mechanic.setCnpj(body.getCnpj());
        mechanic.setPhone(body.getPhone());
        mechanic.setEmail(body.getEmail());

        return mechanicRepository.save(mechanic);
    }

    public void delete(UUID id) {
        mechanicRepository.deleteById(id);
    }
}
