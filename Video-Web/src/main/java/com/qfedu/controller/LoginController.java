package com.qfedu.controller;

import com.qfedu.pojo.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired //从spring容器中去一个它的实现类，赋值给它
            AdminService adminService;


    @RequestMapping("/showLogin")
    public String showLogin(){
        return "behind/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin){

        boolean result = adminService.validateLogin(admin);
        System.out.println(result);
        if(result){
            return "success";
        }else{
            return "fail";
        }

    }
}
