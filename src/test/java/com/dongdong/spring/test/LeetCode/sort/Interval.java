package com.dongdong.spring.test.leetCode.sort;

import lombok.Data;

/**
 * @Description:
 * @Date: 2020/8/25  18:10
 * @Author: dongdong
 */
@Data
public class Interval {
    private  int   start;
    private  int    end;
   public Interval( int start, int end){
       this.start=start;
       this.end=end;
   }
}
