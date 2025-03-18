package com.jdbc.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpMapper {

    Connection connection = null;

    public EmpMapper() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb4";
        String name = "root";
        String password = "liu123456";
        connection = DriverManager.getConnection(url, name, password);
    }

    //根据number更新
    public int updateByNumber(int emp_id,String newName,int salary,String department) throws SQLException {
        //1.定义sql
        String sql = "update emp set emp_name = ?,salary = ?,department = ? where emp_id = ? " ;
        //2.创建执行sql的对象
        PreparedStatement pm = connection.prepareStatement(sql);
        //3.给对象填充
        pm.setString(1,newName);
        pm.setInt(2,salary);
        pm.setString(3,department);
        pm.setInt(4,emp_id);
        //4.执行sql
        int result = pm.executeUpdate();
        return result;
        //查询
        //pm.executeQuery();
    }

}
