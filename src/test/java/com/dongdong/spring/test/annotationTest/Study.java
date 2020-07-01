package com.dongdong.spring.test.annotationTest;

/**
 * @Description:
 * @Date: 2020/6/16  13:36
 * @Author: dongdong
 */
public class Study implements IWork {
    @Override
    public void work() {
        System.out.println("好好学习");
    }
}
