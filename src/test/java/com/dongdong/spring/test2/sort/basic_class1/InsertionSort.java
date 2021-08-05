package com.dongdong.spring.test2.sort.basic_class1;

import com.dongdong.spring.test2.sort.CommonUtils;
import org.springframework.util.CollectionUtils;

/**
 * @author dongDong.pang
 * @date 2021/8/3 19:55
 */
public class InsertionSort {

    //sort
    private static void  sort(int[] arr){
        if(arr.length<=1){
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0 && arr[j]>arr[j+1];j--){
                    //swap
                    CommonUtils.swapData(arr,j,j+1);
            }

        }
        //print
        CommonUtils.printData(arr);
    }


    public static void main(String[] args) {
        sort(CommonUtils.arr);
    }
}
