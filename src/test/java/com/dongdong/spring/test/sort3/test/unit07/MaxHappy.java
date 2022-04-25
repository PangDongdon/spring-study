package com.dongdong.spring.test.sort3.test.unit07;

import advanced_class_07.Code_03_BiggestSubBSTInTree;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class MaxHappy {

    @Data
    public static class Staff {
        public int value;
        public List<Staff> next;

        public Staff(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
        public int come;
        public int noCome;

        public ReturnType(int come, int noCome) {
          this.come=come;
          this.noCome=noCome;
        }
    }

    private static ReturnType getMax(Staff head){
        if(head==null || CollectionUtils.isEmpty(head.next)){
            return new ReturnType(head.value,0);
        }
        int comMax=head.value;
        int noComeMax=0;
        List<ReturnType> lists=new ArrayList<>();
        for(Staff staff:head.next){
            lists.add(getMax(staff));
        }

        for(ReturnType returnType:lists){
            comMax+=returnType.noCome;
            noComeMax+=Math.max(returnType.come,returnType.noCome);
        }
        return  new ReturnType(comMax,noComeMax);
    }

    public static void main(String[] args) {
        Staff staff=new Staff(9);
        staff.next= Lists.newArrayList(new Staff(8),new Staff(10));
        System.out.println(getMax(staff).come);
    }
}
