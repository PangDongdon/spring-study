package com.dongdong.spring.test.spring;

import com.dongdong.spring.ApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @Description:
 * @Date: 2020/12/17  15:30
 * @Author: dongdong
 */
public class Test  extends ApplicationTests {
/*
    @org.junit.Test
    public void test(){
        AbstractApplicationContext context= new AnnotationConfigApplicationContext("com.dongdong.spring");
        context.getBean("student");
    }*/
  @Autowired
    private Teacher teacher;
  @Autowired
    private Student student;
  @org.junit.Test
    public void test(){
      teacher.test();
     // student.test();
  }
}
