package com.dongdong.spring.test;

import com.dongdong.spring.ApplicationTests;
import com.dongdong.spring.service.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/11  14:48
 */
public class serviceTest  extends ApplicationTests {
    @Autowired
    private DemoService demoService;
    @Test
    public void test() {
        try {
            demoService.call();
        }catch(Exception e){
            e.getMessage();
        }
    }

}
