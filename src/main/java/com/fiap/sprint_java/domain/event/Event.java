package com.fiap.sprint_java.domain.event;

import com.fiap.sprint_java.domain.car.Car;
import com.fiap.sprint_java.domain.customer.Customer;
import com.fiap.sprint_java.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Table(name = "service")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event {

    @Id
    @GeneratedValue()
    private UUID id;

    @Column(name = "price", nullable = true)
    private Double price;

    @Column(name = "service_date", nullable = false)
    private ZonedDateTime date;

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
