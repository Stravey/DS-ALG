package com.jdbc.jdbc_second.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrdersMapper {

    Connection connection;

    public OrdersMapper() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cap";
        String user = "root";
        String password = "liu123456";
        connection = DriverManager.getConnection(url, user, password);
    }
}
