package com.dongdong.spring.test.testPackage;

import net.dongliu.commons.Sys;
import org.junit.Test;

import java.util.StringJoiner;

/**
 * @Description:
 * @Date: 2020/11/20  9:40
 * @Author: dongdong
 */
public class TestStringJoiner {
    static int   i;
    public  TestStringJoiner(){
        i=4;
    }
    public TestStringJoiner(int j){
        this.i=j;
    }


    @Test
    public void test(){
        TestStringJoiner ss=new TestStringJoiner();
        TestStringJoiner ss1=new TestStringJoiner(5);
        System.out.print(ss.i+","+","+TestStringJoiner.i);
    }

    @Test
    public void test1(){
        StringJoiner stringJoiner=new StringJoiner(",","[","]");
        stringJoiner.add("pang").add("dong").add("dong");
        System.out.print(stringJoiner);
    }


    public void test2(){
        StringJoiner stringJoiner=new StringJoiner(",","[","]");
        stringJoiner.setEmptyValue("default");
        System.out.print(stringJoiner.toString());
    }

    @Test
    public void  test3(){
        StringJoiner rgbJoiner = new StringJoiner(
                ",", "[", "]");
        StringJoiner cmybJoiner = new StringJoiner(
                "-", "[", "]");
        rgbJoiner.add("Red")
                .add("Green")
                .add("Blue");
        cmybJoiner.add("Cyan")
                .add("Magenta")
                .add("Yellow")
                .add("Black");
        rgbJoiner.merge(cmybJoiner);
        System.out.println(rgbJoiner.toString());
    }



}
