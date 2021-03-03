package com.dongdong.spring.test2.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2021/2/5  13:35
 * @Author: dongdong
 */
public class RadixSort {

    public static void main(String[] args) {
        DisplayData.printResult(RadixSort(RequestParam.params));
    }

    public static int[] RadixSort(int[] arr){

        if(arr.length<2){
            return  arr;
        }
        int N=1;
        int maxValue=arr[0];
        //获得最大的数
        for(int element:arr){
            if(element>maxValue){
                maxValue=element;
            }
        }
        //获取最大的位数
        while(maxValue/10!=0){
            maxValue=maxValue/10;
            N+=1;
        }
        //根据位数进行遍历
        for(int i=0;i<N;i++){
            List<List<Integer>> radix=new ArrayList<>();
            //初始化数据
            for(int k=0;k<10;k++){
                radix.add(new ArrayList<Integer>());
            }
            //
            for(int element:arr){
                int idx=(element/(int)Math.pow(10,i))%10;
                radix.get(idx).add(element);
            }
            int idx=0;
            for(List<Integer> l:radix){
                for(int n: l){
                    arr[idx++]=n;
                }
            }
        }
        return  arr;
    }

}
