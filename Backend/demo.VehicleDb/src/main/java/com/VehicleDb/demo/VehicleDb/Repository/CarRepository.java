package com.VehicleDb.demo.VehicleDb.Repository;

import com.VehicleDb.demo.VehicleDb.entity.Car;
import java.util.List;

public interface CarRepository {
    void save(Car car);
    Car getById(int id);
    List<Car> getAll();
    int update(Car car,int id);
    int delete(int id);
}
