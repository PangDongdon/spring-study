package com.dongdong.spring.test.testPackage.human;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2019/12/31  15:05
 * @Author: dongdong
 */
public class Man extends  Human {

    public static void main(String [] args){
            Man m=new Man();
            m.setAge(18);
            m.setName("dongdong");
            Human h=m;
            System.out.println(h.getAge());
    }

    @Test
    public void ss(){
       System.out.println(this.getAge());
    }
}
