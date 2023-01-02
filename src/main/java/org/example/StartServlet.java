package org.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(value = "/start", loadOnStartup =1 )
public class StartServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e ) {
            throw new RuntimeException(e);
        }

    }
    public Connection getConnection(){
        try {
            return  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","14271915");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
