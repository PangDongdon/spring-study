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
         //insertSort(a);
        insertSort1(a);
         for(int s:a){
            System.out.println(s);
        }
    }

    public  static   void  insertSort1(int[] ss){
         for(int i=1;i<ss.length;i++){
             int insertVal=ss[i];
             int index=i-1;
             while(index>=0 && insertVal<ss[index]){
                 //插入的数据前移
                   ss[index+1]=ss[index];
                   index--;
             }
                    ss[index+1]=insertVal;
         }
    }

    public void insertSortx(int[] arr){
        //遍历所有数字
        for(int i=1;i<arr.length;i++){
            //当前数字比前一个数字小
            if(arr[i]<arr[i-1]){
                int j;
                //保存当前要遍历的数
                int temp=arr[i];
                for(j=i-1;j>=0 && arr[j]>temp;j--){
                    arr[j+1]=arr[j];
                }
                //把临时变量赋给不满足条件的后一个元素
                arr[j+1]=temp;
            }
        }
    }


}
