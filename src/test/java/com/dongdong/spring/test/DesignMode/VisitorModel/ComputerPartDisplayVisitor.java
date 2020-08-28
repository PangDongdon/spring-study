package com.dongdong.spring.test.DesignMode.VisitorModel;

/**
 * @Description:
 * @Date: 2020/8/28  11:33
 * @Author: dongdong
 */
public class ComputerPartDisplayVisitor implements  ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
      System.out.println("Display computer");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Display mouse");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Display keyboard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Display monitor");
    }
}
