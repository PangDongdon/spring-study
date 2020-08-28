package com.dongdong.spring.test.DesignMode.VisitorModel;

/**
 * @Description:
 * @Date: 2020/8/28  11:20
 * @Author: dongdong
 */
public class Monitor implements  ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
