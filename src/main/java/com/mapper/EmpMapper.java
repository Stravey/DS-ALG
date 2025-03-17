package com.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmpMapper {

    Connection connection = null;

    public EmpMapper() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb4";
        String name = "root";
        String password = "liu123456";
        connection = DriverManager.getConnection(url, name, password);
    }

    //根据number
    public void updateByNumber(int number,String newName,String newPassword) throws SQLException {
        String sql = "update emp set name = " ;
        connection.prepareStatement(sql);
    }

}
