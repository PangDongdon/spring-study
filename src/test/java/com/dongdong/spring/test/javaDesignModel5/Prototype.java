package com.dongdong.spring.test.javaDesignModel5;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/26  19:50
 */
public class Prototype implements  Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Object clone(){
        try{
            return  super.clone();
        }catch(Exception e ){
            e.printStackTrace();
            return  null;
        }
    }
}
