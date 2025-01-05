package com.dongdong.spring.leetcodetop100_2;

import java.util.*;

/**
 * 合并区间
 */
public class Top14Merge {
    public static int[][] merge(int[][] intervals) {
        if(intervals==null){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        //eg{[1,3],[2,4]}
        List<int[]> merged=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int L=intervals[i][0];
            int R=intervals[i][1];
            if(merged.size()==0 || merged.get(merged.size()-1)[1]<L){
                merged.add(new int[]{L,R});
            }else {
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);
            }
        }
      return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] s={{1,3},{2,4}};
        merge(s);
    }
}
