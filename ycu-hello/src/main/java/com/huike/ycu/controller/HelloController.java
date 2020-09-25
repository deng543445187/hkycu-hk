package com.huike.ycu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(String msg){
        return "hello"+msg;
    }
}
