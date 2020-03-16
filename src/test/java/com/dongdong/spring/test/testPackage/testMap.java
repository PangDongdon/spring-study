package com.dongdong.spring.test.testPackage;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Date: 2019/11/19  18:18
 * @Author: dongdong
 */
public class testMap {
//   static  {
//        System.out.println("static 块");
//    }
//    public testMap(){
//        System.out.println("创建新型变量");
//    }
    private String name="dd";

    public testMap(String name) {
        this.name = name;
    }

    public static void main(String[] args){
         testMap t=new testMap("dd");
         System.out.println(t.toString());
//        Map<String,Object> map=new HashMap<>();
//        map.put("1",22);
//        map.put("2",33);
//        System.out.println(map);
    }
}
