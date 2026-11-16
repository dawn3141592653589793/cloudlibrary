package com.itheima.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        try{
            InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }
//static {
//    try {
//        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//        if (reader != null) {
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        } else {
//            throw new RuntimeException("无法加载mybatis-config.xml配置文件，请检查文件路径或文件是否存在！");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//        throw new RuntimeException("初始化SqlSessionFactory时发生错误！", e);
//    }
//}
//
//    public static SqlSession getSession() {
//        if (sqlSessionFactory == null) {
//            throw new IllegalStateException("SqlSessionFactory未正确初始化！");
//        }
//        return sqlSessionFactory.openSession(true);
//    }
}
