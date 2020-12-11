package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/11/26  11:41
 * @Author: dongdong
 */
public class Sugar<ss> {

    @Test
    public void test(){
      Integer a=1;
      Integer b=2;
      Integer c=3;
      Integer d=3;
      Integer e=321;
      Integer f=321;
      Long g=3L;
      System.out.println(c==d);//true
      System.out.println(e==f);//true
      System.out.println(c==(a+b));
      System.out.println(c.equals(a+b));
      System.out.println(g==(a+b));
      System.out.println(g.equals(a+b));
    }

}
