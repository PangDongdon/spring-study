package com.dongdong.spring.test.leetCode.sort;


import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 合并区间
 * @Date: 2020/8/20  17:01
 * @Author: dongdong
 */
public class Sort56 {

    public static class Solution1{

        public List<Interval>  merge(List<Interval> lists){
            //1.极端情况判断
            if(lists.size()<=1){
                return lists;
            }
            //2.排序
            Collections.sort(lists,(o1,o2)->o1.getStart()-o2.getStart());
            List<Interval> result=new ArrayList<>();
            for(int i=0;i<lists.size();i++){
                int start=lists.get(i).getStart();
                int end=lists.get(i).getEnd();
                while(i<lists.size() && end>=lists.get(i).getStart()){
                    end=Math.max(end,lists.get(i).getEnd());
                    i++;
                }
                result.add(new Interval(start,end));
                i--;
            }
            return  result;
        }
    }
}
