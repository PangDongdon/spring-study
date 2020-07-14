package com.dongdong.spring.test.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Date: 2020/6/29  16:11
 * @Author: dongdong
 */
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Inheritable {
}
