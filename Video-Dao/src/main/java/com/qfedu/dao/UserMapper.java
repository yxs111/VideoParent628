package com.qfedu.dao;

import com.qfedu.pojo.User;

/**
 * Created by Administrator on 2019/6/21.
 */
public interface UserMapper {
    int loginEmail(String email);
    void insertUser(User user);

    int selectUser(User user);

    User selectUserByEmail(String email);

    void updateUserById(User user);

    void updateUserImageByEmail(User user);
}
