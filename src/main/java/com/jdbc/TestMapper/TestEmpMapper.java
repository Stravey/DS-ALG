package com.jdbc.TestMapper;

import com.jdbc.mapper.EmpMapper;

import java.sql.SQLException;

public class TestEmpMapper {
    public static void main(String[] args) throws SQLException {
        test1();
    }

    public static void test1() throws SQLException {
        EmpMapper empMapper = new EmpMapper();
        int result = empMapper.updateByNumber(8,"王五",10000,"营销部");
        if(result > 0){
            System.out.println("success update");
        }else {
            System.out.println("fail update");
        }
    }
}
