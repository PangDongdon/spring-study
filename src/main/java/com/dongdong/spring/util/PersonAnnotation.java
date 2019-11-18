package com.dongdong.spring.util;

import java.lang.annotation.*;

/**
 * person 注解类
 * @Description:
 * @Date: 2019/11/5  14:43
 * @Author: dongdong
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Inherited
public @interface PersonAnnotation {

    public String name() default "dd";

    public int age() default  23;

}
