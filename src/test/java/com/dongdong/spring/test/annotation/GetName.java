package com.dongdong.spring.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description:
 * @Date: 2020/6/29  16:29
 * @Author: dongdong
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GetName {
     String name() default "ss";
     int age() default 18;
}
