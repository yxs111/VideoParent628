package com.qfedu.service;

import com.qfedu .pojo.User;

/**
 * Created by Administrator on 2019/6/21.
 */
public interface UserService {
    boolean loginEmail(String email);
    void insertUser(User user);

    boolean selectUser(User user);

    User selectUserByEmail(String email);

    void updateUserById(User user);

    void updateUserImageByEmail(String s, String email);
}
