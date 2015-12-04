package com.spring.sys;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 15-5-28.
 */
public abstract  class BaseDao<T> extends SqlSessionDaoSupport {

    private static SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void set(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
