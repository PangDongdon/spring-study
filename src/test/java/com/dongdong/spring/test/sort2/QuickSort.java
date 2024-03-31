package com.dongdong.spring.test.sort2;

import org.junit.Test;

public class QuickSort {

    public  void  test(int[] arr,int L,int R){
        if(arr==null || arr.length<2){
            return;
        }
        if(L<R){
          JavaUtil.swapNum(arr,(L+(int)(Math.random()*(R-L+1))),R);
          int[] p=partiotion(arr,L,R);
          test(arr,L,p[0]-1);
          test(arr,p[1]+1,R);
        }
    }


    public  int[] partiotion(int[] arr,int L,int R){
        int less=L-1;
        int more=R;
        while(L<more){
            if(arr[L]<arr[R]){
                JavaUtil.swapNum(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                JavaUtil.swapNum(arr,--more,L);
            }else{
                L++;
            }
        }
        JavaUtil.swapNum(arr,more,R);
        return  new int[]{less+1,more};
    }

    @Test
    public void dd(){
    int[] aa= JavaUtil.s;
    test(aa,0,aa.length-1);
    JavaUtil.printNum(aa);
    }
}
