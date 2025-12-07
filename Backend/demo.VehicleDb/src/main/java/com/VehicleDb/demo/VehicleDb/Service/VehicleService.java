package com.VehicleDb.demo.VehicleDb.Service;

import com.VehicleDb.demo.VehicleDb.entity.Car;
import java.util.List;

public interface VehicleService {
	void addCar(Car car);
    Car getCarById(int id);
    List<Car> getAllCars();
    int updateCar(Car car,int id);
    int deleteCar(int id);
	

}
