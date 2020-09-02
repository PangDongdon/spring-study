package com.dongdong.spring.test.leetCode.sort;

import net.dongliu.commons.collection.Lists;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: 最大数
 * @Date: 2020/9/1  10:13
 * @Author: dongdong
 */
public class Sort179 {

    public  String getMaxValue(int[] a){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            //0-9
            while (a[i]>0) {
                if (a[i] >= 0 && a[i] < 10) {
                    list.add(a[i]);
                    break;
                }else {
                    int a1 = a[i] % 10;
                    list.add(a1);
                    a[i] = a[i] / 10;
                }
            }
        }
        //对list进行排序
        int sum=0;
        list=Lists.sort(list);
        for(int i=list.size()-1;i>=0;i--){
            int aa=list.get(i);
            sum=sum+aa*(int)Math.pow(10,i);
        }
        return  String.valueOf(sum);
    }

    @Test
    public void test(){
       int[]  aa={3,30,34,5,9};
        //int[]  aa={10,2};
        System.out.println(getMaxValue(aa));
    }


    public static class Solution1{
        public String largestNumber(int[] num){
            if(num.length==0){
                return "";
            }
            if(num.length==1){
                return  Integer.toString(num[0]);
            }
            String[] str=new String[num.length];
            for(int i=0;i<num.length;i++){
                str[i]=Integer.toString(num[i]);
            }
            Arrays.sort(str,new StringComparator());
            StringBuilder  sb=new StringBuilder("");
            for(int i=num.length-1;i>=0;i--){
                sb.append(str[i]);
            }
            if(sb.charAt(0)=='0'){
                return  "0";
            }
            return  sb.toString();
        }


    class  StringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(o1.length()==0 && o2.length()==0){
                return 0;
            }
            if(o2.length()==0){
                return  1;
            }
            if(o1.length()==0){
                return  -1;
            }
            for(int i=0;i<o1.length() &&i<o2.length();i++){
                if(o1.charAt(i)>o2.charAt(i)){
                    return 1;
                }else if(o1.charAt(i)<o2.charAt(i)){
                    return  -1;
                }
            }
            if(o1.length()==o2.length()){
                return  0;
            }

            if(o1.length()>o2.length()){
                if(o1.charAt(0)<o1.charAt(o2.length())){
                    return 1;
                }else if(o1.charAt(0)>o1.charAt(o2.length())) {
                    return  -1;
                }else{
                    return  compare(o1.substring(o2.length()),o2);
                }
            }else{
                if(o2.charAt(0)<o2.charAt(o1.length())){
                    return -1;
                }else if(o2.charAt(0)>o2.charAt(o1.length())){
                    return  1;
                }else{
                    return  compare(o1,o2.substring(o1.length()));
                }
            }
        }
    }

        @Test
        public void test(){
            int[]  aa={3,30,35,5,9};
            //int[]  aa={10,2};
            System.out.println(largestNumber(aa));
        }
    }
}
