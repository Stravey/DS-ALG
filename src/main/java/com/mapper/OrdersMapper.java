package com.mapper;

import java.sql.*;

public class OrdersMapper {

    Connection connection = null;

    public OrdersMapper() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb4";
        String user = "root";
        String password = "liu123456";
        connection = DriverManager.getConnection(url, user, password);
    }

    public int selectAll() throws SQLException {
        String sql = "select * from orders";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return count;
    }
}
