package com.dongdong.spring.test;

import com.dongdong.spring.ApplicationTests;
import com.dongdong.spring.service.DemoService;
import net.dongliu.commons.Sys;
import org.apache.logging.log4j.ThreadContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        //System.out.println(ThreadContext.getContext());
        //System.out.println(ThreadContext.class.getName());
        AbstractApplicationContext  context= new ClassPathXmlApplicationContext("");
        context.refresh();
    }

    @Test
    public void test1(){
        System.out.println("3号枪".replaceAll("[^0-9]", "").trim());
    }

}
