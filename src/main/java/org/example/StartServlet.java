package org.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(value = "/start", loadOnStartup = 1)
public class StartServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection =DBConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select* from cars");
            ResultSet resultSet = preparedStatement.executeQuery();
            addCarsToCash(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void addCarsToCash(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            String name= resultSet.getString("name");
            String color= resultSet.getString("color");
            int id = resultSet.getInt("id_car");
            Cash.getInstance().add(new Car(id,name,color));
        }
    }


}
