package com.dongdong.spring.test.sort;
/**
 * 插入排序
 *
 * */
public class InsertSort {
//    public static void main(String[] args) {
//        int temp=0;
//        int[] arr={1,2,5,3,4};
//        for(int i=0;i<arr.length-1;i++){
//            for(int j=i+1;j>0;j--){
//                if(arr[j]<arr[j-1]){
//                    temp=arr[j-1];
//                    arr[j-1]=arr[j];
//                    arr[j]=temp;
//                }else {
//                    break;
//                }
//            }
//        }
//        //outPut result
//        for(int ss:arr){
//            System.out.println(ss);
//        }
//    }

//    public static void main(String[] args) {
//        int n=0;
//        int temp=0;
//        int[] a={2,1,5};
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j>0 && a[j]<a[j-1];--j){
//                int tmp=a[j];a[j]=a[j-1];a[j-1]=tmp;
//            }
//        }
//        for(int ss:a){
//            System.out.println(ss);
//        }
//    }

    //简单插入排序
    public  static void insertSort(int[] a){
        //定义一个中间量
        int value;
        for(int i=0;i<a.length-1;i++){
            int perCount=i;
            value=a[perCount+1];
            while(perCount>=0 && a[perCount]>value){
                a[perCount+1]=a[perCount];
                perCount--;
            }
            a[perCount+1]=value;
        }
    }


    public static void main(String[] args) {
          int[] a={2,1,33,0};
         insertSort(a);
         for(int s:a){
            System.out.println(s);
        }
    }

}
