package com.dongdong.spring.test.sort3.test.unit06;

public class SubArrayMaxSum {

    public static  int getMaxSum(int[] arr){
        if(arr==null){
            return  0;
        }
        int cur=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            cur+=arr[i];
            max=Math.max(max,cur);
            if(cur<0){
                cur=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /*int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(getMaxSum(arr1));

        int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
        System.out.println(getMaxSum(arr2));

        int[] arr3 = { -2, -3, -5, -1 };
        System.out.println(getMaxSum(arr3));*/
        //121
        //3
        //-1
        int[] arr4={1,-1,0,-2,3,5,-2,8,7,-4};
        System.out.println(getTwoArrayMaxSum(arr4));
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static  int getTwoArrayMaxSum(int[] arr){
        if(arr==null){
            return 0;
        }
        int length=arr.length;
        int[] leftArray=new int[length];
        leftArray[0]=arr[0];
        int[] rightArray=new int[length];
        rightArray[length-1]=arr[length-1];
        //生成左->右最大数组
        int cur=0;
        for(int i=1;i<length;i++){
            cur+=arr[i];
            leftArray[i]=Math.max(leftArray[i-1],cur);
            cur= Math.max(cur, 0);
        }

        //生成右->左最大数组
        int cur2=0;
        for(int i=length-2;i>-1;i--){
            cur2+=arr[i];
            rightArray[i]= Math.max(cur2,rightArray[i+1]);
            cur2=cur2>0?cur2:0;
        }
        printArray(leftArray);
        printArray(rightArray);
        //获取子数组的最大和
        int sum=0;
        for(int i=0;i<length-1;i++){
            sum=Math.max(leftArray[i]+rightArray[i+1],sum);
        }
        return sum;
    }
}
