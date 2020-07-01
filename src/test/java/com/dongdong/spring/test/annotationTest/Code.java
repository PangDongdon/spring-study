package com.dongdong.spring.test.annotationTest;
/**
 * @Description:
 * @Date: 2020/6/16  13:37
 * @Author: dongdong
 */
public class Code implements IWork {
    @Override
    public void work() {
        System.out.println("敲代码");
    }
}
