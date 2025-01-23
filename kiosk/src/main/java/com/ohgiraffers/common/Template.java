package com.ohgiraffers.common;

import com.ohgiraffers.model.dao.MenuMapper;
import com.ohgiraffers.model.dto.MenuDTO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "root";
    private static String PASSWORD = "qwer1234";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {


        if(sqlSessionFactory == null) {

            Environment env = new Environment("dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD));

            Configuration config = new Configuration(env);
            config.getTypeAliasRegistry().registerAlias("MenuDTO", MenuDTO.class);
            config.addMapper(MenuMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        }

        return sqlSessionFactory.openSession(false);
    }
}
