package com.dongdong.spring.test.javaDesignModel7;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  15:27
 */
public class Women  extends  Person{

    public Women(){
        setType("women");
    }
    @Override
    public void address() {
        Clothing clothing=getClothing();
        clothing.personCloth(this);
    }
}
