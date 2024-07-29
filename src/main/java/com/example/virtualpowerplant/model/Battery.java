package com.example.virtualpowerplant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "battery")
public class Battery {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "watt_capacity")
    private int wattCapacity;

}


