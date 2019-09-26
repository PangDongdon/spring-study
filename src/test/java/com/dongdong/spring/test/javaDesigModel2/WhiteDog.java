package com.dongdong.spring.test.javaDesigModel2;

import org.junit.Test;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  17:48
 */
public class WhiteDog implements  IDog {

    @Override
    public void describe(){
        System.out.println("这是条白狗");
    }

    @Test
    public void test(){
      new WhiteAnimalFactory().createCat().describe();
    }

}
