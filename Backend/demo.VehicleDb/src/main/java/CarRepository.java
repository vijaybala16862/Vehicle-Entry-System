package com.VehicleDb.demo.VehicleDb.DAO;

import com.VehicleDb.demo.VehicleDb.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper maps each row in your result set to a Car object
    private final RowMapper<Car> mapper = new RowMapper<Car>() {
        @Override
        public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
            Car car = new Car();
            car.setId(rs.getInt("Id"));      // Match DB column EXACTLY
            car.setModel(rs.getString("Model"));
            car.setBrand(rs.getString("Brand"));
            car.setPrice(rs.getDouble("Price"));
            return car;
        }
    };

    // Fetch all cars
    public List<Car> findAll() {
        return jdbcTemplate.query("SELECT * FROM vehicle", mapper);
    }

    // Fetch one car by ID
    public Car findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM vehicle WHERE Id=?", mapper, id);
    }

    // Insert a new car
    public int save(Car car) {
        return jdbcTemplate.update(
                "INSERT INTO vehicle (Model, Brand, Price) VALUES (?, ?, ?)",
                car.getModel(), car.getBrand(), car.getPrice()
        );
    }

    // Update an existing car
    public int update(Car car) {
        return jdbcTemplate.update(
                "UPDATE vehicle SET Model=?, Brand=?, Price=? WHERE Id=?",
                car.getModel(), car.getBrand(), car.getPrice(), car.getId()
        );
    }

    // Delete a car
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM vehicle WHERE Id=?", id);
    }
}
