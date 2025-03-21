package com.jdbc.mapper;

import com.jdbc.pojo.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerMapper {

    Connection connection = null;

    public WorkerMapper() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/mydb4";
        String name = "root";
        String password = "liu123456";
        connection = DriverManager.getConnection(url, name, password);
    }

    //根据number更新
    public int updateByNumber(int emp_id,String newName,int salary,String department) throws SQLException {
        //1.定义sql
        String sql = "update mydb4.worker set emp_name = ?,salary = ?,department = ? where emp_id = ? " ;
        //2.创建执行sql的对象
        PreparedStatement pm = connection.prepareStatement(sql);
        //3.给对象填充
        pm.setString(1,newName);
        pm.setInt(2,salary);
        pm.setString(3,department);
        pm.setInt(4,emp_id);
        //4.执行sql
        return pm.executeUpdate();
        //查询
        //pm.executeQuery();
    }

    public List<Worker> selectAll() throws Exception {
        String sql = "select * from Worker";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Worker> workers = new ArrayList<Worker>();
        while (rs.next()) {
            //封装数据
            Worker worker = new Worker();
            worker.setId(rs.getInt("emp_id"));
            worker.setName(rs.getString("emp_name"));
            worker.setSalary(rs.getDouble("salary"));
            worker.setDepartment(rs.getString("department"));
            workers.add(worker);
        }
        return workers;
    }

    //输出所有的信息（只需将sql传入即可）
    private void DisplayAllInformation(String sql) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Worker worker = new Worker();
            int workerId = rs.getInt("emp_id");
            String workerName = rs.getString("emp_name");
            double workerSalary = rs.getDouble("salary");
            String department = rs.getString("department");
            System.out.println(workerId + " " + workerName + " " + workerSalary + " " + department);
        }
    }

    //只输出id信息
    private void DisplayIdInformation(String sql) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int workerId = rs.getInt("emp_id");
            System.out.println(workerId);
        }
    }

    //只输出name姓名
    private void DisplayNameInformation(String sql) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            String workerId = rs.getString("emp_name");
            System.out.println(workerId);
        }
    }

    //查询财务部的员工信息
    public void searchDepartmentOfFinacial() throws SQLException {
        String sql = "select * from worker where department = '财务部'";
        DisplayAllInformation(sql);
    }

    //查询工资大于8000的员工信息
    public void searchSalaryOver8000() throws SQLException {
        String sql = "select * from worker where salary > 8000";
        DisplayAllInformation(sql);
    }

    //根据工资进行排序
    public void OrderBySalary() throws SQLException {
        String sql = "select * from worker order by salary desc";
        DisplayAllInformation(sql);
    }

    //查询每个部门第二高的员工信息
    public void SearchSecondSalary() throws SQLException {
        String sql = "select * from worker where salary > (select max(salary) from worker)";
        DisplayAllInformation(sql);
    }


}
