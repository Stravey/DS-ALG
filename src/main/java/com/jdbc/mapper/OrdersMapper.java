package com.jdbc.mapper;

import com.jdbc.pojo.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersMapper {

    Connection conn = null;

    public OrdersMapper() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb4";
        String user = "root";
        String password = "liu123456";
        conn = DriverManager.getConnection(url, user, password);
    }

    public List<Orders> selectAll() throws SQLException {
        String sql = "select * from orders";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return new ArrayList<Orders>(count);
    }
}
