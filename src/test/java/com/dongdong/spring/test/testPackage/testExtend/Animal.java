package com.dongdong.spring.test.testPackage.testExtend;

import lombok.Data;

/**
 * @Description:
 * @Date: 2020/11/24  16:38
 * @Author: dongdong
 */
@Data
public class Animal {
    private String name;

    public void setName(){
        this.name="122";
    }
}
