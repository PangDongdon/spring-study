package com.dongdong.spring.test.leetCode.sort;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:  有效的字母异位词
 * @Date: 2020/9/2  14:58
 * @Author: dongdong
 */
public class Sort242 {

    public boolean checkString(String str1,String str2){
        Map<Character,Integer>  treeMap1=getMap(str1);
        Map<Character,Integer>  treeMap12=getMap(str2);
        if(treeMap1.size()==treeMap12.size()){
            for(Map.Entry entry:treeMap1.entrySet()){
                if(treeMap12.get(entry.getKey())!=entry.getValue()){
                    return false;
                }
            }
            return true;
        }else{
            return  false;
        }
    }


    @Test
    public void test(){
        String s1="rat";
        String s2="car";
        System.out.println(checkString(s1,s2));
//        char[] cc=new char[]{'a','b','c'};
//        System.out.println(cc);
    }

    private Map<Character,Integer> getMap(String str){
        Map<Character,Integer> treeMap= new TreeMap<>();
        char[] c=str.toCharArray();
        for(int i=0;i<c.length;i++){
            if(!treeMap.containsKey(c[i])){
                treeMap.put(c[i],1);
            }else{
                treeMap.put(c[i],treeMap.get(c[i])+1);
            }
        }
        return  treeMap;
    }

}
