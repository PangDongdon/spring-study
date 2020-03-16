package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/1/15  11:06
 * @Author: dongdong
 */
public class MultiplyBehave {

    public String name="dd";
    public void active(){
        System.out.println("加强锻炼，everyDay");
    }

 static    class Sss extends  MultiplyBehave{
        public String name="love";
        public void active(){
            System.out.println("study everyDay");
        }


        public static  void main(String[] args){
           MultiplyBehave m=new Sss();
           System.out.println(m.name);
           m.active();
           boolean ss="ddd" instanceof Object;
           System.out.println();
        }
    }

}
