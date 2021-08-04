package com.dongdong.spring.test.springSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Test {

    @org.junit.Test
    @Resource
    public void  test(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("");
    }


}
