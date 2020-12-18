package com.dongdong.spring.test.leetCode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @Description:
 * @Date: 2020/12/17  11:38
 * @Author: dongdong
 */
public class Sort84 {

 public  int largestRectangleArea(int[] heights){
     int len=heights.length;
     Stack<Integer> s=new Stack<>();
     int maxArea=0;
     for(int i=0;i<=len;i++){
         int h=(i==len?0:heights[i]);
         if(s.isEmpty() || h>=heights[s.peek()]){
             s.push(i);//1,5,6
         }else{
             int tp=s.pop();
             maxArea=Math.max(maxArea,heights[tp]* (s.isEmpty()?i:i-1-s.peek()));
             i--;
         }
     }
     return  maxArea;
 }

  @Test
  public void test(){
     int[] ss={2,1,5,6,2,3};
     System.out.println(largestRectangleArea(ss));
  }




}
