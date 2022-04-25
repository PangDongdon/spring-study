package com.dongdong.spring.test.sort3.test.unit08;

import javax.xml.bind.annotation.XmlID;
import java.util.Arrays;
import java.util.Comparator;

public class Russian_Doll_Envelopes {

    public static class Dot{
        private  int w;
        private  int h;
        public Dot(int weigh,int height){
            this.h=height;
            this.w=weigh;
        }
    }

    public  static  class DotComparator implements Comparator<Dot> {
        @Override
        public int compare(Dot o1, Dot o2) {
            if(o1.w==o2.w){
                if(o1.h<o2.h){
                    return 1;
                }else if(o1.h==o2.h){
                    return 0;
                }else{
                    return -1;
                }
            }else{
                if(o1.w<o2.w){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    }

    public static int maxEnvelopes(int[][] es) {
        if(es==null || es.length==0 || es[0]==null || es[0].length<2){
            return 0;
        }
        //初始化数据
        Dot[] dots=new Dot[es.length];
        for(int i=0;i<dots.length;i++){
            dots[i]=new Dot(es[i][0],es[i][1]);
        }
        Arrays.sort(dots,new DotComparator());
        int[] ends=new int[es.length];
        ends[0]=dots[0].h;
        int right=0;
        int l=0;
        int r=0;
        int m=0;
        for(int i=0;i<dots.length;i++){
            r=right;
            while(l<=r){
                m=(l+r)>>1;
               if(dots[i].h>ends[m]){
                   l=m+1;
               }else{
                   r=m-1;
               }
            }
            right=Math.max(right,l);
            ends[l]=dots[i].h;
        }
        return  right+1;
    }


    public static void main(String[] args) {
        int[][] test = { { 4, 3 }, { 1, 2 }, { 5, 7 }, { 5, 3 }, { 1, 1 }, { 4, 9 } };
        System.out.println(maxEnvelopes(test));

        String str = "";

        System.out.println(str.substring(0, 0).equals(""));

    }
}
