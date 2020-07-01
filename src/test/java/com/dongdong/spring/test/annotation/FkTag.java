package com.dongdong.spring.test.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Date: 2020/6/29  17:48
 * @Author: dongdong
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FkTag {
    String name();
    int age();
}
