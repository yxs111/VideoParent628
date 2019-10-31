package com.qfedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Annoation {
    @RequestMapping("/{myname}/pathVariable2.do")

    @ResponseBody

    public String pathVariable2(@PathVariable(value = "myname") String name){

        System.out.println("name = "+name);

        return "index";

    }
    }
