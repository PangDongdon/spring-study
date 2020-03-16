package com.dongdong.spring.service.properties;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Date: 2019/11/27  17:55
 * @Author: dongdong
 */
public class GwServiceIml implements GwService {
    @Autowired
    GwProperties gwProperties;
    @Override
    public void Hello() {
        String name=gwProperties.getName();
        System.out.println(name+"说晚上好！");
    }
}
