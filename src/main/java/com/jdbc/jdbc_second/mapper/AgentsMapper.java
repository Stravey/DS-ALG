package com.jdbc.jdbc_second.mapper;

import com.jdbc.jdbc_second.pojo.Agents;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentsMapper {

    Connection connection = null;

    public AgentsMapper() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cap";
        String user = "root";
        String password = "liu123456";
        connection = DriverManager.getConnection(url, user, password);
    }

    //查询全部
    public List<Agents> selectAll() throws SQLException {
        String sql = "select * from agents";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Agents> list = new ArrayList<Agents>();
        while(rs.next()) {
            Agents o = new Agents();
            o.setAid(rs.getString("aid"));
            o.setAname(rs.getString("aname"));
            o.setCity(rs.getString("city"));
            o.setPercent(rs.getInt("percent"));
            list.add(o);
        }
        return list;
    }

    // 按城市查询
    public List<Agents> selectByCity(String city) throws SQLException {
        String sql = "select * from agents where city = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Agents> list = new ArrayList<Agents>();
        while(rs.next()) {
            Agents o = new Agents();
            o.setAid(rs.getString("aid"));
            o.setAname(rs.getString("aname"));
            o.setCity(rs.getString("city"));
            o.setPercent(rs.getInt("percent"));
            list.add(o);
        }
        return list;
    }
}
