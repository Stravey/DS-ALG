package com.jdbc.TestMapper;

import com.jdbc.mapper.WorkerMapper;
import com.jdbc.pojo.Worker;

import java.sql.SQLException;
import java.util.List;

public class TestEmpMapper {
    public static void main(String[] args) throws Exception {
        //test1();
        test2();
    }

    public static void test1() throws SQLException {
        WorkerMapper workerMapper = new WorkerMapper();
        int result = workerMapper.updateByNumber(8,"王五",10000,"营销部");
        if(result > 0){
            System.out.println("success update");
        }else {
            System.out.println("fail update");
        }
    }

    public static void test2() throws Exception {
        WorkerMapper workerMapper = new WorkerMapper();
        List<Worker> workerList = workerMapper.selectAll();
        for (Worker worker : workerList) {
            System.out.println(worker.toString());
        }

    }
}
