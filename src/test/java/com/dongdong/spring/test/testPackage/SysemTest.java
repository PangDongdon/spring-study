package com.dongdong.spring.test.testPackage;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Map;
import java.util.Properties;

/**
 * @Description:
 * @Date: 2020/5/7  16:55
 * @Author: dongdong
 */
public class SysemTest {
    public static void main(String[] args) {
       /* Map<String,String>  env=System.getenv();
        for(Map.Entry<String,String> name: env.entrySet()){
            System.out.println(name.getKey()+"====="+name.getValue());
        }
        //获取指定环境变量
        System.out.println("JAVA_HOME");
        //获取系统属性
        Properties properties=System.getProperties();*/
       System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
    }
}
