package com.VehicleDb.demo.VehicleDb.ServiceImpl;

import com.VehicleDb.demo.VehicleDb.Repository.CarRepository;
import com.VehicleDb.demo.VehicleDb.Service.VehicleService;
import com.VehicleDb.demo.VehicleDb.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {

  @Autowired
  CarRepository carRepository;


    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car getCarById(int id) {

        return carRepository.getById(id);
    }

    @Override
    public List<Car> getAllCars() {

        return carRepository.getAll();
    }

    @Override
    public int updateCar(Car car,int id) {
        return carRepository.update(car,id);
    }

    @Override
    public int deleteCar(int id) {
        return carRepository.delete(id);
    }
	

}
