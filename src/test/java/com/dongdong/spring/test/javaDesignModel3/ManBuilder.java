package com.dongdong.spring.test.javaDesignModel3;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  19:04
 */
public class ManBuilder implements IBuildPerson {

    Person person;
    public  ManBuilder(){
        person=new Man();
    }

    @Override
    public void buildHead() {
      person.setHead("建造head");
    }

    @Override
    public void buildFoot() {
     person.setFoot("建造foot");
    }

    @Override
    public Person bulidPerson() {
        return person;
    }
}
