package com.dongdong.spring.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/10/27  17:00
 * @Author: dongdong
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用List保持着常量池的引用，避免Full GC 回收常量池行为
        List<String> list=new ArrayList<>();
        //10MB的PermSize 在integer 范围内足够产生OOM 了
        int i=0;
        while(true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
