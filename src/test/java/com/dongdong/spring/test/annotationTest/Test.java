package com.dongdong.spring.test.annotationTest;

import com.dongdong.spring.ApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Date: 2020/6/16  13:37
 * @Author: dongdong
 */
public class Test extends ApplicationTests {
    @Autowired
    private IWork work;

    @org.junit.Test
    public void test(){

    }
}
