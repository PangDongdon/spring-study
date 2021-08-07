package com.dongdong.spring.test2.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2021/2/5  11:33
 * @Author: dongdong
 */
public class BucketSort {

    private static int[] getMinAndMax(List<Integer> arr){
        int maxValue=arr.get(0);
        int minValue=arr.get(0);
        for(int i:arr){
            if(i>maxValue){
                maxValue=i;
            }else if(i<minValue){
                minValue=i;
            }
        }
        return  new int[]{minValue,maxValue};
    }

    public  static List<Integer> BucketSort(List<Integer> arr,int bucket_size){
        if(arr.size()<2 || bucket_size==0){
            return  arr;
        }
        //look arr max and min value
        int[] extremum=getMinAndMax(arr);
        //get min value
        int minValue=extremum[0];
        //get max value
        int maxValue=extremum[1];
        int bucket_cnt=(maxValue-minValue)/bucket_size+1;
        List<List<Integer>> buckets=new ArrayList<>();
        for(int i=0;i<bucket_cnt;i++){
            buckets.add(new ArrayList<Integer>());
        }
        for(int element: arr){
            int idx=(element-minValue)/bucket_size;
            buckets.get(idx).add(element);
        }

        for(int i=0;i<buckets.size();i++){
            if(buckets.get(i).size()>1){
                //buckets.set(i,sort(buckets.get(i),bucket_size/2));
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(List<Integer> bucket:buckets){
            for(int element:bucket){
                result.add(element);
            }
        }
        return  result;
    }


}
