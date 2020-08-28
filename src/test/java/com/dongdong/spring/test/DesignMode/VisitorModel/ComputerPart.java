package com.dongdong.spring.test.DesignMode.VisitorModel;

/**
 * @Description:
 * @Date: 2020/8/28  11:17
 * @Author: dongdong
 */
public interface ComputerPart {
    void accept( ComputerPartVisitor computerPartVisitor);
}
