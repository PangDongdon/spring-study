package com.dongdong.spring.test.sort3.test.unit06;

public class SubArrayMaxProduct {

    public static  double getMaxProduct(double[] arr){
        if(arr==null){
            return  0;
        }
        double max=arr[0];
        double min=arr[0];
        double minEnd=0;
        double maxEnd=0;
        double res=0;
        for(int i=1;i<arr.length;i++){
            maxEnd=max*arr[i];
            minEnd=min*arr[i];
            max=Math.max(Math.max(maxEnd,minEnd),arr[i]);
            min=Math.min(Math.min(minEnd,maxEnd),arr[i]);
            res=Math.max(max,res);
        }
        return  res;
    }

    public static void main(String[] args) {
        double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
        System.out.println(getMaxProduct(arr));
    }
}
