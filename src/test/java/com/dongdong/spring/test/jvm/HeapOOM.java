package com.dongdong.spring.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/10/23  16:40
 * @Author: dongdong
 */
public class HeapOOM {
    static  class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
