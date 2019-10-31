package com.qfedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/anno")
public class Annoation2 {
    @RequestMapping("/testRequestParam")

    public String requestParams1(String username ){

//        System.out.println("name = "+name);
        System.out.println(username);
        System.out.println("aaaaa");
        return "404";

    }
    @RequestMapping("/requestParams2.do")

    public String requestParams2(@RequestParam(value = "name",required = false) String names){

        System.out.println("name = "+names);

        return "index";

    }
}
