package org.example;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CarServiceImpl implements CarService {
    private  DBConnection dbConnection = DBConnection.getInstance();
    private Cash cash = Cash.getInstance();

    @Override
    public void saveCar(Car car) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into cars (id_car,name,color) values(?,?,?)");
            statement.setInt(1, car.getId());
            statement.setString(2, car.getName());
            statement.setString(3, car.getColor());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cash.add(car);
    }

    @Override
    public  Car getById(int id) {

        Optional<Car> car = cash.getById(id);
        if (car.isEmpty()) {
            Connection connection = dbConnection.getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * from cars where id_car=?");
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                 car = Optional.ofNullable(get(resultSet));
                if(car.get().getName()!=null){
                    cash.add(car.get());
                }
                return car.get();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return car.get();
        }
    }

    @Override
    public void delete(int id) {

        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from cars WHERE id_car=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cash.delete(id);
    }

    @Override
    public List<Car> getAll() {
        return cash.getAll();

    }

    @Override
    public void updateCar(Car car) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update cars set color=? where id_car=?;");
            preparedStatement.setString(1, car.getColor());
            preparedStatement.setInt(2, car.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cash.updateCar(car);

    }

    private Car get(ResultSet resultSet) {
        Car car = new Car();
        try {

            String name = resultSet.getString("name");
            int id = resultSet.getInt("id_car");
            String color = resultSet.getString("color");
            if (StringUtils.isNoneBlank(name, color) && id != 0) {
                car = new Car(id, name, color);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return car;
    }
}
