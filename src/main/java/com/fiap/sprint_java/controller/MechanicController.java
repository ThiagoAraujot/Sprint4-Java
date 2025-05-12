package com.fiap.sprint_java.controller;

import com.fiap.sprint_java.domain.mechanic.Mechanic;
import com.fiap.sprint_java.dto.mechanic.MechanicRequestDTO;
import com.fiap.sprint_java.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mechanic")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @PostMapping
    public ResponseEntity<Mechanic> save(@RequestBody MechanicRequestDTO body) {
        Mechanic mechanic = this.mechanicService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(mechanic);
    }

    @GetMapping
    public ResponseEntity<List<Mechanic>> findAll() {
        List<Mechanic> mechanics = this.mechanicService.findAll();
        return ResponseEntity.ok(mechanics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> findById(@PathVariable String id) {
        Mechanic mechanic = this.mechanicService.findById(UUID.fromString(id));

        if (mechanic == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(mechanic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mechanic> update(@PathVariable String id, @RequestBody MechanicRequestDTO body) {
        Mechanic mechanic = this.mechanicService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(mechanic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Mechanic mechanic = this.mechanicService.findById(UUID.fromString(id));

        if (mechanic == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.mechanicService.delete(mechanic.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
