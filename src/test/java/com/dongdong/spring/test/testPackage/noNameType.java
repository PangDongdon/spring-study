package com.dongdong.spring.test.testPackage;

import javax.validation.groups.Default;

/**
 * @Description:
 * @Date: 2020/4/29  16:37
 * @Author: dongdong
 */
public interface noNameType {
    void missYou();
    default int add(){
        return  2;
    }
}
