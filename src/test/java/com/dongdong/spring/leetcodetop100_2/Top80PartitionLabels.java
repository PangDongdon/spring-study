package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.List;

/**
 *划分字母区间
 */
public class Top80PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] ss=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            ss[s.charAt(i)-'a']=i;
        }
        List<Integer> res=new ArrayList<>();
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
           end=Math.max(end, ss[s.charAt(i)-'a']);
           if(end==i){
               res.add(end-start+1);
               start=end+1;
           }
        }
        return res;
    }
}
