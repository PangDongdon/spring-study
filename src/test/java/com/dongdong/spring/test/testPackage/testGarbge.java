package com.dongdong.spring.test.testPackage;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/10/18  16:33
 * @Author: dongdong
 */
public class testGarbge {

    public static void main(String[] args){

        List<GarbageCollectorMXBean> list= ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollectorMXBean : list) {
             System.out.println(garbageCollectorMXBean.getName());
        }
    }



}
