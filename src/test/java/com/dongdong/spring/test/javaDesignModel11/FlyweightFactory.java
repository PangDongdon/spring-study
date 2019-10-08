package com.dongdong.spring.test.javaDesignModel11;

import org.apache.tomcat.util.codec.binary.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  11:10
 */
public class FlyweightFactory {

    private static Map<String,Flyweight>  flyweights=new HashMap();
    public FlyweightFactory(String args){
        flyweights.put(args,new FlyweightImpl());
    }

    public  static  Flyweight getFlyweight(String key){
       if(flyweights.get(key)==null){
           flyweights.put(key,new  FlyweightImpl());
       }
       return flyweights.get(key);
    }

    public static int getSize(){
        return flyweights.size();
    }

}
