package com.dongdong.spring.test.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Date: 2020/8/5  15:03
 * @Author: dongdong
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**供应商编号*/
     int id() default -1;
    /**供应商名称*/
     String name() default "";
    /**供应商地址*/
     String address() default "";
}
