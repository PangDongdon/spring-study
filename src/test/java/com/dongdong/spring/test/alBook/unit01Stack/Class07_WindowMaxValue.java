package com.dongdong.spring.test.alBook.unit01Stack;

import com.dongdong.spring.test.sort.test.util.Utils;

import java.util.LinkedList;

/**生成窗口最大值数组*/
public class Class07_WindowMaxValue {

    public  static  int[] getWindowMaxValue(int[] arr,int w){
        if(arr==null || arr.length<1 || arr.length<w){
            return arr;
        }
        LinkedList<Integer> qmax=new LinkedList<>();
        int index=0;
        int[] res=new int[arr.length-w+1];
        for(int i=0;i<arr.length;i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if(i>=w-1){
              res[index++]=arr[qmax.peekFirst()];
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] ss=new int[]{4,3,5,4,3,3,6,7};
        int[] res=getWindowMaxValue(ss,3);
        Utils.printArr(res);
    }
}
