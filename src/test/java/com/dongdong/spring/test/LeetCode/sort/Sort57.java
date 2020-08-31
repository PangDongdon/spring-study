package com.dongdong.spring.test.leetCode.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 插入区间
 * @Date: 2020/8/28  18:20
 * @Author: dongdong
 */
public class Sort57 {

    public static class Solution1{

        public List<Interval>  insert(List<Interval>  intervals,Interval newInterval){
            List<Interval> result= new ArrayList<>();
            int i=0;
            while(i<intervals.size() && intervals.get(i).getEnd()<newInterval.getStart()){
                result.add(intervals.get(i++));
            }
            while(i<intervals.size() && intervals.get(i).getStart()<=newInterval.getEnd()){
                newInterval=new Interval(
                      Math.min(intervals.get(i).getStart(),newInterval.getStart()),
                      Math.max(intervals.get(i).getEnd(),newInterval.getEnd())
                );
                i++;
            }
            result.add(newInterval);
            while (i<intervals.size()){
                result.add(intervals.get(i++));
            }
            return  result;
        }


        @Test
        public void test(){
            List<Interval> intervals=new ArrayList<>();
            Interval interval=new Interval(1,3);
            intervals.add(interval);
            interval=new Interval(6,9);
            intervals.add(interval);
            Interval ss=new Interval(2,5);
            System.out.println(insert(intervals,ss));
        }
    }

    //1.估计最大时间和空间复杂度
    //2.选择合适数据结构
    //3.选择算法



}
