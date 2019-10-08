package com.dongdong.spring.test.javaDesignModel3;

import org.junit.Test;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  19:11
 */
public class PersonDirect  {

    public Person buildPersonDirect( IBuildPerson  person){
        person.buildFoot();
        person.buildHead();
        return  person.bulidPerson();
    }


    @Test
    public void testMan(){
        PersonDirect personDirect=new PersonDirect();
        Person person=personDirect.buildPersonDirect(new ManBuilder());
        System.out.println(person.getFoot()+":"+person.getHead());
    }


}
