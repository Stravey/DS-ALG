package com.jdbc.TestMapper;

import com.jdbc.mapper.WorkerMapper;
import com.jdbc.pojo.Worker;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestWorkerMapper {
    public static void main(String[] args) throws Exception {
        //test1();
    }

    @Test
    public void test1() throws SQLException {
        WorkerMapper workerMapper = new WorkerMapper();
        int result = workerMapper.updateByNumber(8,"王五",10000,"营销部");
        if(result > 0){
            System.out.println("success update");
        }else {
            System.out.println("fail update");
        }
    }

    @Test
    public void test2() throws Exception {
        WorkerMapper workerMapper = new WorkerMapper();
        List<Worker> workerList = workerMapper.selectAll();
        for (Worker worker : workerList) {
            System.out.println(worker.toString());
        }
    }

    @Test
    public void test3() throws SQLException {
        WorkerMapper workerMapper = new WorkerMapper();
        workerMapper.searchDepartmentOfFinacial();
    }

    @Test
    public void test4() throws SQLException {
        WorkerMapper workerMapper = new WorkerMapper();
        workerMapper.searchSalaryOver8000();
    }

    @Test
    public void test5() throws SQLException {
        WorkerMapper workerMapper = new WorkerMapper();
        workerMapper.OrderBySalary();
    }
}
