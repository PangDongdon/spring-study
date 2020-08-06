package com.dongdong.spring.test.annotation;

import java.lang.reflect.Field;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description: 注解处理器
 * @Date: 2020/8/5  15:14
 * @Author: dongdong
 */
public class FruitInfoUtil {
    public  static void getFruitInfo(Class<?> clazz){
        String strFruitProvider="供应商信息";
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider=(FruitProvider)field.getAnnotation(FruitProvider.class);
                strFruitProvider="供应商编号："+fruitProvider.id()+"  供应商name:"+fruitProvider.name()+"  供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }

    public static void main(String[] args) {
        getFruitInfo(Apple.class);
    }
}
