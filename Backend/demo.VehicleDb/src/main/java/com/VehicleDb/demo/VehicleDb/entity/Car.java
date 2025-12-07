package com.VehicleDb.demo.VehicleDb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    private int id;
    private String model;
    private String brand;
    private double price;
}
