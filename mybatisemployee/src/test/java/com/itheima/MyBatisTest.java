package com.itheima;

import com.itheima.Utils.MyBatisUtils;
import com.itheima.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    @Test
    public void select01(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        Employee employee01 = sqlSession.selectOne("select01",2);
        System.out.println(employee01);
        sqlSession.close();
    }

    @Test
    public void insert02(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        Employee employee=new Employee();
        employee.setId(4);
        employee.setName("赵六");
        employee.setAge(100);
        employee.setPosition("老板");
        sqlSession.insert("insert02",employee);
        System.out.println("添加成功！");
        sqlSession.close();
    }

    @Test
    public void update03(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        Employee employee=new Employee();
        employee.setId(3);
        employee.setName("陈二");
        employee.setAge(40);
        employee.setPosition("经理");
        sqlSession.insert("update03",employee);
        System.out.println("更新成功！");
        sqlSession.close();
    }

    @Test
    public void delete04(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        sqlSession.delete("delete04",1);
        System.out.println("删除成功！");
        sqlSession.close();
    }
}
