package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.dao.UserMapper;
import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiuZhu on 2015/5/14.
 */
@Service
@Scope("prototype")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;



    @Override
    public List<User> findUserList() {
        return userDao.findUserList();
    }
}
