package com.qfedu.service.impl;

import com.qfedu. dao.UserMapper;
import com.qfedu. pojo.User;
import com.qfedu. service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/6/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    public boolean loginEmail(String email) {
       int a = userMapper.loginEmail(email);
        return a==0 ? true : false;
    }


    public void insertUser(User user) {
        userMapper.insertUser(user);

    }


    public boolean selectUser(User user) {
        int b = userMapper.selectUser(user);
        return b==1 ? true : false;
    }

    public User selectUserByEmail(String email) {
        return userMapper. selectUserByEmail(email);
    }

    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    public void updateUserImageByEmail(String fileName, String email) {
        User user =new User();
        user.setImgurl(fileName);
        user.setEmail(email);
        userMapper.updateUserImageByEmail(user);
    }
}
