package com.dongdong.spring.test.DesignMode.VisitorModel;

/**
 * @Description:
 * @Date: 2020/8/28  11:43
 * @Author: dongdong
 */
public class VisitorPattern {
    public static void main(String[] args) {
        ComputerPart computerPart=new Computer();
        computerPart.accept(new ComputerPartDisplayVisitor());
    }
}
