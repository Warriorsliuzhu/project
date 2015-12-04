package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.model.User;
import com.spring.sys.BaseDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 15-5-28.
 */
@Repository
@Scope("prototype")
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int insert(User user) {
        super.getSqlSession().insert("");
        return 0;
    }

    @Override
    public List<User> findUserList() {
       return super.getSqlSession().selectList("com.spring.dao.UserMapper.findUserList");

    }
}
