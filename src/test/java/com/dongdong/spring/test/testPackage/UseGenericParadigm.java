package com.dongdong.spring.test.testPackage;

import org.apache.poi.ss.formula.functions.T;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/11/22  9:19
 * @Author: dongdong
 */
public class UseGenericParadigm {

    public static void main(String[] args){
       /* gent<? extends  String> o;
        o=new gent<String>();
        o.test();*/
       /* Integer[] i=fun1(1,2,4);
        System.out.println(i);*/
       /* List<Integer>  list=new ArrayList();
        list.add(1);
       Integer s= list.get(0);
        System.out.println();*/
       /* List<? super Integer> list=new ArrayList<>();
        list.add(4);*/
       List<Integer> integerList= Lists.newArrayList();
       List<String> stringList=Lists.newArrayList();
       System.out.println(integerList.getClass()==stringList.getClass());

    }



    public static <T> T[]  fun1( T...arg){
        return arg;
    }

   public static <T> T dd(T c){
        T t= (T) new String("ds");
        return t;
   }



}

/*
class gent<T>{
    public void test(){
        System.out.println("gent");
    }


}*/

