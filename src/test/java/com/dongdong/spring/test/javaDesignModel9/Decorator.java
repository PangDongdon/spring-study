package com.dongdong.spring.test.javaDesignModel9;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  9:39
 */
public  abstract  class Decorator implements Person {
    private Person person;
    public void setPerson(Person person){
        this.person=person;
    }

    @Override
    public void eat() {
        person.eat();
    }
}
