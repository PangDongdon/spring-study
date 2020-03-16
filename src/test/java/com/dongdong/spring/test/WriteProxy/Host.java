package com.dongdong.spring.test.WriteProxy;

/**
 * @Description:
 * @Date: 2019/12/9  16:12
 * @Author: dongdong
 */
public class Host implements  Rent {
    @Override
    public void rent() {
        System.out.println("租房");
    }
}
