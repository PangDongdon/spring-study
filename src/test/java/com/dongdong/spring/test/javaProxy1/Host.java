package com.dongdong.spring.test.javaProxy1;

/**
 * @Description:
 * @Date: 2019/11/16  16:09
 * @Author: dongdong
 */
public class Host implements Rent {

    @Override
    public void rent() {
       System.out.println("房屋出租");
    }


}
