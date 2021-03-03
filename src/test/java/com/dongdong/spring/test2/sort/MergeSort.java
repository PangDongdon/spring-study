package com.dongdong.spring.test2.sort;

import net.dongliu.commons.Sys;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @Date: 2021/2/4  15:35
 * @Author: dongdong
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] request= RequestParam.params;
        if(request.length==1){

        }
        int middle=request.length/2;
        int[] arr1= Arrays.copyOfRange(request,0,middle);
        arr1=SelectionSort.test(arr1);
        System.out.println("###########");
        int[] arr2= Arrays.copyOfRange(request,middle,request.length);
        arr2=SelectionSort.test(arr2);
        System.out.println("#####排序后的结果#####");
        merge(arr1,arr2);
    }

    private static int[] merge(int[] arr1,int[] arr2){
        int[] result=new int[arr1.length+arr2.length];
        int index=0,index2=0,index3=0;
        while(index2<arr1.length && index3<arr2.length){
            if(arr1[index2]<arr2[index3]){
                result[index]=arr1[index2];
                index2+=1;
            }else {
                result[index]=arr2[index3];
                index3+=1;
            }
           index+=1;
        }
        if(index2<arr1.length){
            while (index2<arr1.length){
                result[index]=arr1[index2];
                index2+=1;
                index+=1;
            }
        }else{
            while (index3<arr2.length){
                result[index]=arr2[index3];
                index3+=1;
                index+=1;
            }
        }
        DisplayData.printResult(result);
        return result;
    }


}
