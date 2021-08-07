package com.dongdong.spring.test.testPackage.testExtend;

import lombok.Data;

/**
 * @Description:
 * @Date: 2020/11/24  16:44
 * @Author: dongdong
 */
@Data
public class Dog extends  Animal {
    private String name;

    @Override
    public void setName() {
        super.setName();
    }

    public static void main(String[] args) {
        System.out.print("");
    }
}
