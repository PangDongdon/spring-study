package com.dongdong.spring.test.DesignMode.FilterModel;

/**
 * @Description:
 * @Date: 2020/8/28  16:06
 * @Author: dongdong
 */
public class AuthenticationFilter implements  Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request:"+ request);
    }
}
