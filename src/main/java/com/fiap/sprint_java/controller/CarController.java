package com.fiap.sprint_java.controller;

import com.fiap.sprint_java.domain.car.CarRequestDTO;
import com.fiap.sprint_java.domain.car.CarResponseDTO;
import com.fiap.sprint_java.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<CarResponseDTO> save(@RequestBody CarRequestDTO body) {
        CarResponseDTO car = this.carService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> findAll() {
        List<CarResponseDTO> cars = this.carService.findAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> findById(@PathVariable String id) {
        CarResponseDTO car = this.carService.findById(UUID.fromString(id));

        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDTO> update(@PathVariable String id, @RequestBody CarRequestDTO body) {
        CarResponseDTO car = this.carService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        CarResponseDTO car = this.carService.findById(UUID.fromString(id));

        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.carService.delete(car.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
