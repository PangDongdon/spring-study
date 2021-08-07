package com.dongdong.spring.test.testPackage;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Date: 2020/12/22  17:03
 * @Author: dongdong
 */
public class TestBoolean {
  private  final  Boolean  ss=Boolean.FALSE;

  public  void  doSomething(){
      synchronized (ss){
          System.out.println("ss");
      }
  }

  @Test
    public void test(){
      doSomething();
  }








}
