package com.fiap.sprint_java.dto.car;

import com.fiap.sprint_java.domain.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CarResponseDTO {
    private UUID id;
    private String model;
    private Integer factory_year;
    private Customer customer;
}
