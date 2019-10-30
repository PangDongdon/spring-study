package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/10/16  19:40
 * @Author: dongdong
 */
public class JavaVNStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {

        JavaVNStackSOF javaVNStackSOF = new JavaVNStackSOF();
        try {
            javaVNStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println(javaVNStackSOF.stackLength);
            throw e;
        }
    }
}
