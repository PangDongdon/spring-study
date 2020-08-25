package com.dongdong.spring.test.sort;

/**
 * 冒泡排序
 *
 * */
public class BubblingSort {
//    public static void main(String[] args) {
//        //定义一个中间变量
//        int temp=0;
//        //定义一个整数数组
//        int[] arr={2,333,444,1,4,5,6,899};
//        for(int i=0;i<arr.length-1;i++){
//            for (int j=arr.length-1;j>i;j--){
//                //后一个比前一小，则交换
//                if(arr[j]<arr[j-1]){
//                    temp=arr[j];
//                    arr[j]=arr[j-1];
//                    arr[j-1]=temp;
//                }
//            }
//        }
//        //outPut result
//        for(int ss:arr){
//            System.out.println(ss);
//        }
//
//    }

//  /**冒泡排序*/
//    public static void main(String[] args) {
//        boolean flag=false;
//        int temp=0;
//        int[] aa={2,3,4,1,0};
//        for(int i=0;i<aa.length-1;i++){
//            for(int j=0;j<aa.length-1-i;j++){
//                if(aa[j]>aa[j+1]){
//                    temp=aa[j];
//                    aa[j]=aa[j+1];
//                    aa[j+1]=temp;
//                    flag=true;
//                }
//            }
//            if(!flag){
//                break;
//            }
//        }
//        for(int ss:aa){
//            System.out.println(ss);
//        }
//    }


    public static void main(String[] args) {
        int[] a={2,3,4,1,0};
        int n=a.length;
        if(n<=1) return;
        for(int i=0;i<n-1;i++){
            //提前退出冒泡排序的标志
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int tmp=a[j];a[j]=a[j+1];a[j+1]=tmp;//交换元素
                    flag=true;
                }
            }
            if(flag==false) break;//如果没有元素交换，则已经有序，结束
        }
        for(int ss:a){
            System.out.println(ss);
        }
    }
}
