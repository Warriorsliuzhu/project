package com.spring;

import com.spring.dao.UserDao;
import com.spring.model.User;
import com.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class UserTest {

    private UserService userService;



    @Before
    public void before() {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                , "classpath:conf/spring-mybatis.xml","classpath:conf/mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");

    }

    @Test
    public void addUser() {
       List<User> users = userService.findUserList();
   }
}
