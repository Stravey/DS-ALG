package com.jdbc.TestMapper;

import java.sql.SQLException;

public class TestOrdersMapper {

    public static void main(String[] args) {
        System.out.println("TestOrdersMapper");
    }

    public void selectAll() throws SQLException {
        String sql = "select * from orders";
    }
}
