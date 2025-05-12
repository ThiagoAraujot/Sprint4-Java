package com.fiap.sprint_java.service;

import com.fiap.sprint_java.domain.customer.Customer;
import com.fiap.sprint_java.dto.customer.CustomerRequestDTO;
import com.fiap.sprint_java.dto.customer.CustomerResponseDTO;
import com.fiap.sprint_java.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerResponseDTO toResponseDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        dto.setEmail(customer.getEmail());
        return dto;
    }

    public CustomerResponseDTO save(CustomerRequestDTO body) {
        Customer newCustomer = new Customer();

        newCustomer.setName(body.getName());
        newCustomer.setPhone(body.getPhone());
        newCustomer.setEmail(body.getEmail());

        Customer savedCustomer = customerRepository.save(newCustomer);

        return toResponseDTO(savedCustomer);
    }

    public List<CustomerResponseDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public CustomerResponseDTO findById(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        return toResponseDTO(customer);
    }

    public CustomerResponseDTO update(String id, CustomerRequestDTO body) {
        Customer customer = customerRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setName(body.getName());
        customer.setPhone(body.getPhone());
        customer.setEmail(body.getEmail());

        Customer updatedCustomer = customerRepository.save(customer);
        return toResponseDTO(updatedCustomer);
    }

    public void delete(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        customerRepository.delete(customer);
    }
}
