package com.jdbc.mapper;

import com.jdbc.pojo.Orders;
import com.jdbc.pojo.Worker;

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


    static void PreparedStatement(String sql, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Worker worker = new Worker();
            int workerId = rs.getInt("emp_id");
            String workerName = rs.getString("emp_name");
            double workerSalary = rs.getDouble("salary");
            String department = rs.getString("department");
            System.out.println(workerId + " " + workerName + " " + workerSalary + " " + department);
        }
    }

    public List<Orders> selectAll() throws SQLException {
        String sql = "select * from orders";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Orders> list = new ArrayList<>();
        while (rs.next()) {
            Orders o = new Orders();
            o.setOld(rs.getInt("oid"));
            o.setPrice(rs.getDouble("price"));
            o.setPayType(rs.getInt("payType"));
            list.add(o);
        }
        return list;
    }

    private void DisplayAllInformation(String sql) throws SQLException {
        PreparedStatement(sql, conn);
    }

}
