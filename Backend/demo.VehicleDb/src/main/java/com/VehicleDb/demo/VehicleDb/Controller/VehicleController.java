package com.VehicleDb.demo.VehicleDb.Controller;

	import com.VehicleDb.demo.VehicleDb.Service.VehicleService;
	import com.VehicleDb.demo.VehicleDb.entity.Car;
	import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

	import java.util.List;
	
	@RestController
	@RequestMapping("/api/cars")
    @CrossOrigin(origins = "http://localhost:4200")
    public class VehicleController {

	    @Autowired
	    private VehicleService vehicleService;

	    @PostMapping("/add")
	    public String addCar(@RequestBody Car car) {
	        vehicleService.addCar(car);
	        return "Car Added Successfully!";
	    }

	   
	    @GetMapping("/all")
	    public List<Car> getAllCars() {
	        return vehicleService.getAllCars();
	    }

	
	    @GetMapping("/{id}")
	    public Car getCarById(@PathVariable int id) {
	        return vehicleService.getCarById(id);
	    }

	 
	    @PutMapping("/update/{id}")
	    public String updateCar(@RequestBody Car car,@PathVariable int id) {
	        vehicleService.updateCar(car,id);
	        return "Car Updated Successfully!:";
	    }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteCar(@PathVariable int id) {
            vehicleService.deleteCar(id);
            return ResponseEntity.ok("Car Deleted Successfully!");
        }
	}


