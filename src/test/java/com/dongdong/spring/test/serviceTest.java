package com.dongdong.spring.test;

import com.dongdong.spring.ApplicationTests;
import com.dongdong.spring.service.DemoService;
import net.dongliu.commons.Sys;
import org.apache.logging.log4j.ThreadContext;
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
//        try {
//            demoService.call();
//            String s="ss";
//            s.intern();
//        }catch(Exception e){
//            e.getMessage();
//        }
       System.out.println(ThreadContext.getContext());
        System.out.println(ThreadContext.class.getName());
    }

}
