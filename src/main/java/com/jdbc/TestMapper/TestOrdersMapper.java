package com.jdbc.TestMapper;

import com.jdbc.mapper.OrdersMapper;
import com.jdbc.pojo.Orders;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestOrdersMapper {

    public static void main(String[] args) {

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
