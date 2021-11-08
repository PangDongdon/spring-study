package com.dongdong.spring.test.sort2;

import net.dongliu.commons.Sys;
import org.junit.Test;

public class MergeSort {
  @Test
    public void test(){
       // System.out.println(sort2(JavaUtil.s,0,JavaUtil.s.length-1));
       int [] dd=JavaUtil.s;
       sort(dd,0,JavaUtil.s.length-1);
       JavaUtil.printNum(dd);
    }


    public int  sort2(int[] arr,int l,int r){
        if(arr==null || arr.length<2){
            return 0;
        }
        if(l==r){
            return arr[r];
        }
        int mid=l+((r-l)>>1);
        //System.out.println(mid);
        int s=sort2(arr,l,mid);
        int c=sort2(arr,mid+1,r);
        return Math.max(s,c);
    }


    public void sort(int[] arr,int L,int R){
       if(arr==null || arr.length<2){
           return;
       }
       if(L==R){
           return;
       }
       int  mid=L+((R-L)>>1);
       sort(arr,L,mid);
       sort(arr,mid+1,R);
       merge(arr,L,mid,R);
    }

    private void merge(int[] arr,int L,int mid,int R){
      int[] ss=new int[R-L+1];
      int i=0;
      int p1=L;
      int p2=mid+1;
      while(p1<=mid && p2<=R){
          ss[i++]=arr[p1]<arr[p2] ?arr[p1++]:arr[p2++];
      }
        while(p1<=mid){
            ss[i++]=arr[p1++];
        }

        while(p2<=R){
            ss[i++]=arr[p2++];
        }
        for(int j=0;j<ss.length;j++){
            arr[L+j]=ss[j];
        }
    }


}
