package com.VehicleDb.demo.VehicleDb.Repository;

import com.VehicleDb.demo.VehicleDb.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Car> mapper = new RowMapper<Car>() {
        @Override
        public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
            Car car = new Car();
            car.setId(rs.getInt("id"));
            car.setModel(rs.getString("model"));
            car.setBrand(rs.getString("brand"));
            car.setPrice(rs.getDouble("price"));
            return car;
        }
    };

    @Override
    public void save(Car car) {
        String sql = "INSERT INTO vehicle (model, brand, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, car.getModel(), car.getBrand(), car.getPrice());
    }

    @Override
    public Car getById(int id) {
        String sql = "SELECT * FROM vehicle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public List<Car> getAll() {
        String sql = "SELECT * FROM vehicle";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public int update(Car car, int id) {
        String sql = "UPDATE vehicle SET Model=?, Brand=?, Price=? WHERE id=?";
        return jdbcTemplate.update(sql,
                car.getModel(),
                car.getBrand(),
                car.getPrice(),
                id
        );
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM vehicle WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
