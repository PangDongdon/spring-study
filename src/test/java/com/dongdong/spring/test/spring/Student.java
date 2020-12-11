package com.dongdong.spring.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:循环依赖test
 * @Date: 2020/7/14  16:19
 * @Author: dongdong
 */
@Service
public class Student {
    @Autowired
    private Teacher teacher;
  //  @Autowired
   /* public Student(Teacher teacher){
        this.teacher=teacher;
    }*/
}
