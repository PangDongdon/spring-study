package com.dongdong.spring.test.javaDesignModel7;

import lombok.Data;

/**
 * 桥接模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  15:22
 */
@Data
public abstract class Person {
    private Clothing clothing;
    private String  Type;

    public  abstract void  address();

}
