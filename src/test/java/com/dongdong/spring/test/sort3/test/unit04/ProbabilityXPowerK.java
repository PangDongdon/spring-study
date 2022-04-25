package com.dongdong.spring.test.sort3.test.unit04;

import java.math.BigDecimal;

public class ProbabilityXPowerK {
    public static double randXPowerK(int k) {
        if(k<1){
            return 0;
        }
        double res=0;
        for(int i=0;i<k;i++){
            res=Math.max(res,Math.random());
        }
        return  res;
    }

    public static void main(String[] args) {
        double a=0.5;
        int c=100000;
        int count=0;
        for(int i=0;i<c;i++){
            if(randXPowerK(2)<a){
                count++;
            }
        }
        System.out.println(new BigDecimal(String.valueOf(count)).divide(new BigDecimal(String.valueOf(c))));
    }
}
