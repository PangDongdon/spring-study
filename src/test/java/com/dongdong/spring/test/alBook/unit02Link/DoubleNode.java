package com.dongdong.spring.test.alBook.unit02Link;

import lombok.Data;

@Data
public class DoubleNode {
    public  int  value;
    public DoubleNode next;
    public DoubleNode last;
    public DoubleNode(int value){
        this.value=value;
    }
}
