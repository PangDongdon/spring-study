package com.dongdong.spring.test.leetCode.sort;

import net.dongliu.commons.Sys;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: H指数
 * @Date: 2020/9/2  15:41
 * @Author: dongdong
 */
public class Sort274 {

    public int getHIndex(int[] a){
        int count=a.length; //论文次数
        int temp=count;
        while(true) {
            int sum=0;
            int sub=0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] >= count) {
                    sum++;
                }else{
                    sub++;
                }
            }
            if(sum==count){
                System.out.println(count);
                break;
            }
            count--;
        }
        return 0;
    }


    @Test
    public void  test(){
        int[] aa={3,0,6,1,5};
        getHIndex(aa);
    }

    public int hIndex(int[] citations){
        if(citations==null && citations.length==0){
            return  0;
        }
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=citations.length-i){
                return citations.length-i;
            }
        }
        return 0;
    }
}
