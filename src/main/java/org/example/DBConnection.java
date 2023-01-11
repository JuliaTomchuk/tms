package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","14271915");
        } catch (SQLException e) {
            throw new RuntimeException("Error connection");
        }
    }

    private DBConnection(){}
    public static DBConnection getInstance(){
        if(dbConnection==null){
            synchronized (DBConnection.class){
                if(dbConnection==null){
                    dbConnection=new DBConnection();
                }
            }
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
