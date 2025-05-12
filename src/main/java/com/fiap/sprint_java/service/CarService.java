package com.fiap.sprint_java.service;

import com.fiap.sprint_java.domain.car.Car;
import com.fiap.sprint_java.dto.car.CarRequestDTO;
import com.fiap.sprint_java.dto.car.CarResponseDTO;
import com.fiap.sprint_java.domain.customer.Customer;
import com.fiap.sprint_java.repository.CarRepository;
import com.fiap.sprint_java.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    public CarService(CarRepository carRepository, CustomerRepository customerRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    private CarResponseDTO toResponseDTO(Car car) {
        CarResponseDTO dto = new CarResponseDTO();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setFactory_year(car.getFactory_year());
        dto.setCustomer(car.getCustomer());
        return dto;
    }

    public CarResponseDTO save(CarRequestDTO body) {
        Customer customer = customerRepository.findById(body.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));

        Car newCar = new Car();

        newCar.setModel(body.getModel());
        newCar.setFactory_year(body.getFactory_year());
        newCar.setCustomer(customer);

        Car savedCar = carRepository.save(newCar);

        return toResponseDTO(savedCar);
    }

    public List<CarResponseDTO> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public CarResponseDTO findById(UUID id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));

        return toResponseDTO(car);
    }

    public CarResponseDTO update(String id, CarRequestDTO body) {
        Car car = carRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));

        Customer customer = customerRepository.findById(body.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        car.setModel(body.getModel());
        car.setFactory_year(body.getFactory_year());
        car.setCustomer(customer);

        Car updatedCar = carRepository.save(car);
        return toResponseDTO(updatedCar);
    }

    public void delete(UUID id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));
        carRepository.delete(car);
    }
}
