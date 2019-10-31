package com.qfedu.service.impl;

import com.qfedu.dao.AdminMapper;
import com.qfedu.pojo.Admin;
import com.qfedu.service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminMapper adminMapper;
    public boolean validateLogin(Admin admin) {


        int result = adminMapper.validateLogin(admin);
        return result >0 ? true:false;
    }
}
