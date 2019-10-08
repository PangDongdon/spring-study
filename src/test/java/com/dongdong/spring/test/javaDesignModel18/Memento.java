package com.dongdong.spring.test.javaDesignModel18;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  10:47
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
