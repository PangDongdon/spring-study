package com.dongdong.spring.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Description:
 * @Date: 2019/11/28  9:38
 * @Author: dongdong
 */
@Controller
@EnableWebMvc
@RequestMapping(value = "dd")
public class LoginController {
    @GetMapping(value = "/getUsername")
    public String getLoginUsername(String name,Integer age){
        return "name="+name+"   "+"age="+age;
    }


    public static void main(String[] args) {
        Integer  a=4;
        System.out.println(a.intValue()==4);
    }
}
