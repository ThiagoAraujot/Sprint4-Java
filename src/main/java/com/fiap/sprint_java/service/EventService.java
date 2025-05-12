package com.fiap.sprint_java.service;

import com.fiap.sprint_java.domain.car.Car;
import com.fiap.sprint_java.domain.customer.Customer;
import com.fiap.sprint_java.domain.employee.Employee;
import com.fiap.sprint_java.domain.event.EventResponseDTO;
import com.fiap.sprint_java.domain.event.Event;
import com.fiap.sprint_java.domain.event.EventRequestDTO;
import com.fiap.sprint_java.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final EmployeeRepository employeeRepository;

    public EventService(EventRepository serviceRepository, CustomerRepository customerRepository,
                        CarRepository carRepository, EmployeeRepository employeeRepository) {
        this.eventRepository = serviceRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
    }

    private EventResponseDTO toResponseDTO(Event event) {
        EventResponseDTO dto = new EventResponseDTO();

        dto.setId(event.getId());
        dto.setPrice(event.getPrice());
        dto.setDate(event.getDate());
        dto.setCustomer(event.getCustomer());
        dto.setCar(event.getCar());
        dto.setEmployee(event.getEmployee());

        return dto;
    }

    public EventResponseDTO save(EventRequestDTO body) {
        Customer customer = customerRepository.findById(body.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Car car = carRepository.findById(body.getCarId())
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));

        Employee employee = employeeRepository.findById(body.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        Event newEvent = new Event();

        newEvent.setPrice(body.getPrice());
        newEvent.setDate(body.getDate());
        newEvent.setCustomer(customer);
        newEvent.setCar(car);
        newEvent.setEmployee(employee);

        Event savedEvent = eventRepository.save(newEvent);

        return toResponseDTO(savedEvent);
    }

    public List<EventResponseDTO> findAll() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public EventResponseDTO findById(UUID id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        return toResponseDTO(event);
    }

    public EventResponseDTO update(String id, EventRequestDTO body) {
        Event event = eventRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        Customer customer = customerRepository.findById(body.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Car car = carRepository.findById(body.getCarId())
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));

        Employee employee = employeeRepository.findById(body.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        event.setPrice(body.getPrice());
        event.setDate(body.getDate());
        event.setCustomer(customer);
        event.setCar(car);
        event.setEmployee(employee);

        Event updatedEvent = eventRepository.save(event);
        return toResponseDTO(updatedEvent);
    }

    public void delete(UUID id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));
        eventRepository.delete(event);
    }
}
