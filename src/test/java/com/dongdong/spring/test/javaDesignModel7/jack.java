package com.dongdong.spring.test.javaDesignModel7;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  15:37
 */
public class jack extends  Clothing {
    @Override
    public void personCloth(Person person) {
        System.out.println(person.getType()+"穿马甲");
    }
}
