package com.dongdong.spring.test.designModel1;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  15:44
 */
public class TeacherWork implements  Work {
    @Override
    public void work() {
        System.out.println("老师正在批改作业");
    }
}
