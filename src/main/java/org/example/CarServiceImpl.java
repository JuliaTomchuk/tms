package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private StartServlet startServlet = new StartServlet();

    @Override
    public void saveCar(Car car) {
        Connection connection = startServlet.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into cars (id_car,name,color) values(?,?,?)");
            statement.setInt(1, car.getId());
            statement.setString(2, car.getName());
            statement.setString(3, car.getColor());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> getById(int id) {
        Connection connection = startServlet.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from cars where id_car=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Car> cars = get(resultSet);
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = startServlet.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from cars WHERE id_car=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> getAll() {
        Connection connection = startServlet.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery("SELECT * from cars");
            return get(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateCar(Car car) {
        Connection connection = startServlet.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update cars set color=? where id_car=?;");
            preparedStatement.setString(1, car.getColor());
            preparedStatement.setInt(2, car.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private List<Car> get(ResultSet resultSet) {
        List<Car> cars = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = Integer.valueOf(resultSet.getInt("id_car"));
                String color = resultSet.getString("color");
                Car car = new Car(id, name, color);
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return cars;
    }
}
