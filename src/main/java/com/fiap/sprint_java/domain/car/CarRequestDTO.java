package com.fiap.sprint_java.domain.car;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CarRequestDTO {
    private String model;
    private Integer factory_year;
    private UUID customerId;
}
