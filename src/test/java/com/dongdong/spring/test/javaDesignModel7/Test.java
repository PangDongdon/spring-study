package com.dongdong.spring.test.javaDesignModel7;

/** 桥接模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  15:45
 */
public class Test {

    public static void main(String[] args){
       men m=new men();
       Women women=new Women();
       lucy l=new lucy();
       jack j=new jack();
       l.personCloth(m);
       j.personCloth(women);
    }
}
