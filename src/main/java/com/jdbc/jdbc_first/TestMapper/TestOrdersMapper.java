package com.jdbc.jdbc_first.TestMapper;

import com.jdbc.jdbc_first.mapper.OrdersMapper;
import com.jdbc.jdbc_first.pojo.Orders;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestOrdersMapper {

    public static void main(String[] args) {
        System.out.println("呵呵");
    }

    @Test
    public void selectAll() throws SQLException {
        OrdersMapper mapper = new OrdersMapper();
        List<Orders> list = mapper.selectAll();
        for (Orders o : list) {
            System.out.println(o.toString());
        }
    }
}
