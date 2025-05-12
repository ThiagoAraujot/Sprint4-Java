package com.fiap.sprint_java.controller;

import com.fiap.sprint_java.dto.event.EventRequestDTO;
import com.fiap.sprint_java.dto.event.EventResponseDTO;
import com.fiap.sprint_java.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponseDTO> save(@RequestBody EventRequestDTO body) {
        EventResponseDTO event = this.eventService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> findAll() {
        List<EventResponseDTO> events = this.eventService.findAll();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> findById(@PathVariable String id) {
        EventResponseDTO event = this.eventService.findById(UUID.fromString(id));

        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDTO> update(@PathVariable String id, @RequestBody EventRequestDTO body) {
        EventResponseDTO event = this.eventService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        EventResponseDTO event = this.eventService.findById(UUID.fromString(id));

        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.eventService.delete(event.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
