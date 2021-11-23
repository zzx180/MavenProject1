package com.zzx.test;


import com.zzx.dao.IUserDao;
import com.zzx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zzx
 */
public class MybatisTest {
    /**
     * 入门案例
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(in);

        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);

        //5.使用代理对象执行方法
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println("user:" + user);
        }

        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
