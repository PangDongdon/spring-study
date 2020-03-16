package com.dongdong.spring.test.testPackage;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Date: 2019/12/16  9:52
 * @Author: dongdong
 */
public class FilterMap {

    @Data
    class Person{
       private  int age;
       private String sex;
       private String name;
    }


    @Test
    public void test(){
    List<Person> personList=new ArrayList<>();
    Person person=new Person();
    person.setAge(9);
    person.setSex("man");
    person.setName("ss");

    Person person1=new Person();
    person1.setAge(20);
    person1.setSex("man");
    person1.setName("ss");

    Person person2=new Person();
    person2.setAge(20);
    person2.setSex("man");
    person2.setName("ss");

    personList.add(person);
    personList.add(person1);
    personList.add(person2);

    List<Integer> list=personList.stream().map(Person::getAge).distinct().collect(Collectors.toList());
//   boolean dd= list.stream().anyMatch(i->i==9);
//   System.out.println(dd);
    System.out.println(list);
    }


    @Test
    public void testReg(){
        String schoolName="上海第二工业大学是真的好差";
        schoolName=schoolName.replaceAll("([\\u4E00-\\u9FA5]{2})[\\u4E00-\\u9FA5]+([\\u4E00-\\u9FA5]{3})","$1********$2");
        System.out.println(schoolName);
    }
    @Test
    public void testPhone(){
        String driverPhone="18721926709";
        driverPhone=driverPhone.replaceAll("(\\d{3})\\d{6}(\\d{2})","$1******$2");
        System.out.println(driverPhone);
    }


       public  enum  DONGDONG{

        A(1,"s"),B(2,"ss"),C(3,"sss");
        private int code;
        private String message;

        DONGDONG(int code, String message){
            this.code=code;
            this.message=message;
        }
    }

        @Test
       public void testEnum(){
        System.out.println(DONGDONG.values());
        for(DONGDONG d:DONGDONG.values()){
            System.out.println(d.code);
        }
       }

}
