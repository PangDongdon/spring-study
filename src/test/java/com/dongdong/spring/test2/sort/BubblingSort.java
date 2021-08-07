package com.dongdong.spring.test2.sort;

/**
 * @Description:
 * @Date: 2021/2/4  10:30
 * @Author: dongdong
 */
public class BubblingSort {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int[] data={4,2,3,55,6};
        sort(data);
        System.out.println("耗时"+(System.currentTimeMillis()-start)+"ms");
    }

    private static  int[] sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            boolean result=true;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                result=false;
            }
            if(result){
                break;
            }
        }
        DisplayData.printResult(arr);
        return  arr;
    }

}
