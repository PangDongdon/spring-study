package com.dongdong.spring.test.javadDesignModel1;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  15:43
 */
public class StudentWork implements  Work {
    @Override
    public void work() {
        System.out.println("学生在写作业");
    }
}
