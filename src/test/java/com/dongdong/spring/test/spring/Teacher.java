package com.dongdong.spring.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:循环依赖test
 * @Date: 2020/7/14  16:20
 * @Author: dongdong
 */
@Service
public class Teacher {
    @Autowired
    private Student student;
   /* @Autowired
    public Teacher (Student student){
         this.student=student;
    }*/
   public void test(){
       System.out.println("test--student");
       student.test();
   }
}
