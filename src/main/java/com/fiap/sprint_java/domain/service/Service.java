package com.fiap.sprint_java.domain.service;

import com.fiap.sprint_java.domain.car.Car;
import com.fiap.sprint_java.domain.customer.Customer;
import com.fiap.sprint_java.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "service")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service {

    @Id
    @GeneratedValue()
    private UUID id;

    private Double price;

    @Column(name = "service_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
