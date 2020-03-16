package com.dongdong.spring.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Date: 2019/11/28  9:38
 * @Author: dongdong
 */
@Controller
@RequestMapping(value = "dd")
public class LoginController {
    @GetMapping(value = "/getUsername")
    public String getLoginUsername(String name,Integer age){
        return "name="+name+"   "+"age="+age;
    }
}
