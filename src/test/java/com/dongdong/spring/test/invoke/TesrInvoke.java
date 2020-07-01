package com.dongdong.spring.test.invoke;

import java.lang.reflect.InvocationTargetException;

/**
 * @Description:  反射测试
 * @Date: 2020/6/15  10:34
 * @Author: dongdong
 */
public class TesrInvoke {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        InvokeUtil.invoke(new Work(),"workHard","dd");
    }
}
