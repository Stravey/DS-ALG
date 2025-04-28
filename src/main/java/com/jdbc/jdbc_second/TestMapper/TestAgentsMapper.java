package com.jdbc.jdbc_second.TestMapper;

import com.jdbc.jdbc_second.mapper.AgentsMapper;
import com.jdbc.jdbc_second.pojo.Agents;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestAgentsMapper {
    @Test
    public void selectAll() throws SQLException {
        AgentsMapper mapper = new AgentsMapper();
        List<Agents> list = mapper.selectAll();
        for(Agents o : list) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void selectByCity() throws SQLException {
        AgentsMapper mapper = new AgentsMapper();
        List<Agents> rm = mapper.selectByCity("New York");
        for(Agents o : rm) {
            System.out.println(o.toString());
        }
    }

    //测试数据插入数据库
    @Test
    public void insert() throws SQLException {
        AgentsMapper mapper = new AgentsMapper();
        Agents o = new Agents();
        o.setAid("134");
        o.setAname("123");
        o.setCity("New York");
        o.setPercent(1);
        mapper.insert(o);
    }

    /**
     * 测试更新数据
     * @author rui
     */
    @Test
    public void update() throws SQLException {
        AgentsMapper mapper = new AgentsMapper();
        Agents o = new Agents();
        o.setPercent(1);
        mapper.update(o);
    }

    /**
     * 测试删除数据
     * @author rui
     */
    @Test
    public void delete() throws SQLException {
        AgentsMapper mapper = new AgentsMapper();
        Agents o = new Agents();
        o.setAid("134");
        o.setAname("123");
        o.setCity("New York");
        o.setPercent(1);
        mapper.delete(o);
    }
}
