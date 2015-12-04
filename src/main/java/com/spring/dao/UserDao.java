package com.spring.dao;

import com.spring.model.User;

import java.util.List;

/**
 * Created by LiuZhu on 2015/5/14.
 */
public interface UserDao {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int insert(User user);

    public List<User> findUserList();
}
