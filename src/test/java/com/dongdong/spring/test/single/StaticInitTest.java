package com.dongdong.spring.test.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/8/24  14:13
 * @Author: dongdong
 */
public class StaticInitTest {

    private static List<Integer> list=null;

    static {
        Singleton.INSTANCE.init();
    }

    private static enum Singleton{
        INSTANCE;

        private Singleton(){
            fullData();
        }

        private void fullData(){
            list=new ArrayList<>();
            for(int i=1;i<9;i++){
                list.add(i);
            }
        }

        private  List<Integer> init(){
            return list;
        }
    }


}
