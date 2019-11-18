package com.dongdong.spring.service;

import org.junit.Test;

import java.io.IOException;

/**
 * @Description:
 * @Date: 2019/11/1  15:24
 * @Author: dongdong
 */
public class TestClass {

        private static int m;

        public static void main(String[] args){
              try{
                  m=m/0;
                 System.out.println(m+1);
              }catch(OutOfMemoryError e){
                 System.out.println(m+2);
              }finally {
                 System.out.println(m+3);
              }
        }

        @Test
       public void person(){
            PersonImpl person=new PersonImpl();
            person.setPersonDao(new teacherImpl());
            person.say();
        }
}
