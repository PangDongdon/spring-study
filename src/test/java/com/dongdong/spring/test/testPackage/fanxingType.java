package com.dongdong.spring.test.testPackage;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/11/29  17:11
 * @Author: dongdong
 */
public class fanxingType {

//    public static  String method(List<String> ss) {
//        System.out.println(ss);
//        return "qqq";
//    }

    public static int method(List<Integer> ss) {
        System.out.println(ss);
        return 1;
    }

    public  static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        method(new ArrayList<String>());
////        method(new ArrayList<Integer>());
//          Integer a= 1;
//          Integer b=2;
//          Integer c=3;
//          Integer d=3;
//          Integer e=321;
//          Integer f=321;
//          Long g=3L;
//        System.out.println(c==d);
//        System.out.println(e==f);
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println(g==(a+b));
//        System.out.println(g.equals(a+b));

       BaseBean<String> baseBean=new BaseBean<>();
       baseBean.setValue("dd");
       //使用反射获取属性的类型
       Field fieldValue=baseBean.getClass().getDeclaredField("value");
       Class<?> Type=fieldValue.getType();

       System.out.println("属性的名称为："+  Type.getName());
       Method method=baseBean.getClass().getDeclaredMethod("getValue");
       Object object=method.invoke(baseBean);
       String   name= object.getClass().getName();
       System.out.println("methodName:"+name);
    }

}

@Data
class  BaseBean<T extends String>{
    T value;
}