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

    // 插入数据
    public void insert(Agents o) throws SQLException {
        String sql = "INSERT INTO AGENTS (aid, aname, city, percent) VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, o.getAid());
        ps.setString(2, o.getAname());
        ps.setString(3, o.getCity());
        ps.setInt(4, o.getPercent());
        int num = ps.executeUpdate();
        if(num > 0) {
            System.out.println("数据插入成功");
        } else {
            System.out.println("数据插入失败");
        }
    }

    // 更新数据
    public void update(Agents o) throws SQLException {
        String sql = "UPDATE AGENTS SET city = ?, percent = ? WHERE aid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, o.getCity());
        ps.setInt(2, o.getPercent());
        ps.setString(3, o.getAid());
        int num = ps.executeUpdate();
        if(num > 0) {
            System.out.println("数据修改成功");
        } else {
            System.out.println("数据修改失败");
        }
    }


    // 删除数据
    public void delete(Agents o) throws SQLException {
        String sql = "DELETE FROM AGENTS WHERE aid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, o.getAid());
        int num = ps.executeUpdate();
        if(num > 0) {
            System.out.println("删除数据成功");
        } else {
            System.out.println("删除数据失败");
        }
    }


}
