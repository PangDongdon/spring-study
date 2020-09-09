package com.dongdong.spring.test.leetCode.sort;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @Description: 通过删除字母匹配到字典里最长单词
 * @Date: 2020/9/4  16:18
 * @Author: dongdong
 */
public class Sort524 {

    public String getMaxStr(String s,String[] strs){
        int max=0;
        int flag=0;
        boolean dd=false;
        for(String x:strs){
         char[] cs=x.toCharArray();
         for(char c1:cs){
             if(!s.contains(String.valueOf(c1))){
                 dd=true;
                 break;
             }
         }
         if(x.length()>max && dd==false){
             max=x.length();
             System.out.println("max:"+max);
             flag++;
         }
         if(x.length()==max && dd==false){
             flag=flag;
         }
        }
        if(flag==0 && dd==true){
            return  null;
        }
        System.out.println("flag:"+flag);
        int result=flag>0 ? flag-1 :0;
        return strs[result];
    }

    @Test
    public void test(){
        String s="abpcplea";
        String[] ss={"ale","apple","monkey","plea"};
        String[] dd={"a","b","c"};
        //System.out.println(getMaxStr(s,dd));
        List<String> list= Lists.newArrayList();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(findLongestWord(s,list));
    }

    public String findLongestWord(String s, List<String> d){
        Collections.sort(d,(a,b)->a.length()==b.length()? a.compareTo(b):b.length()-a.length());
        for(String dictWord:d){
            int i=0;
            for(char c:s.toCharArray()){
                if(i<dictWord.length() && dictWord.charAt(i)==c){
                    i++;
                }
            }
            if(i==dictWord.length()){
                return dictWord;
            }
        }
        return "";
    }
}
