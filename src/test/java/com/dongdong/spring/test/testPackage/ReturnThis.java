package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/12/31  16:14
 * @Author: dongdong
 */
public class ReturnThis {
    public int  age;

    public  ReturnThis grow(){
        age++;
        return  this;
    }


    public  static void main(String[] args){
        ReturnThis  rt=new ReturnThis();
         rt.grow().grow().grow();
         System.out.println(rt.age);
    }
}
