package com.dongdong.spring.leetcodetop100_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *合并区间
 */
public class Top14Merge {
    public int[][] merge(int[][] intervals) {
       if (intervals==null){
           return new int[0][2];
       }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
       List<int[]> res=new ArrayList<>();
       for (int i = 0; i < intervals.length; i++) {
           int L=intervals[i][0];
           int R=intervals[i][1];
           if(res.size()<1 || res.get(res.size()-1)[1]<L){
               res.add(new int[]{L,R});
           }else {
               res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],R);
           }
       }
       return res.toArray(new int[res.size()][]);
    }
}
