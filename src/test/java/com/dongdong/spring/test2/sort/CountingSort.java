package com.dongdong.spring.test2.sort;

/**
 * @Description:
 * @Date: 2021/2/5  10:22
 * @Author: dongdong
 */
public class CountingSort {

    public static  int[] CountingSort(int[] arr){
        if(arr.length<2){
            return  arr;
        }
        //look arr max and min value
        int[] extremum=getMinAndMax(arr);
        //get min value
        int minValue=extremum[0];
        //get max value
        int maxValue=extremum[1];

        int[] countArr=new int[maxValue-minValue+1];
        int[] result=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            countArr[arr[i]-minValue]+=1;
        }
        for(int i=1;i<countArr.length;i++){
            countArr[i]+=countArr[i-1];
        }
        for(int i=arr.length-1;i>=0;i--){
            int idx=countArr[arr[i]-maxValue]-1;
            result[idx]=arr[i];
            countArr[arr[i]-minValue]-=1;
        }
        return result;
    }

    private static int[] getMinAndMax(int[] arr){
        int maxValue=arr[0];
        int minValue=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxValue){
                maxValue=arr[i];
            }else if(arr[i]<minValue){
                maxValue=arr[i];
            }
        }
        return  new int[]{minValue,maxValue};
    }


}
