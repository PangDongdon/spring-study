package com.dongdong.spring.test.DesignMode.FilterModel;

/**
 * @Description:
 * @Date: 2020/8/28  16:07
 * @Author: dongdong
 */
public class DebugFilter implements  Filter {
    @Override
    public void execute(String request) {
        System.out.println("request log :"+request);
    }
}
