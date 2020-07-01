package com.dongdong.spring.test.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Date: 2020/6/29  17:46
 * @Author: dongdong
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FkTags {
    FkTag[] value();
}
