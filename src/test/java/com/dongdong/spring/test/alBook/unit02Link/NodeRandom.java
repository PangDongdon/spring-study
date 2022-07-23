package com.dongdong.spring.test.alBook.unit02Link;

import lombok.Data;

@Data
public class NodeRandom {
    public NodeRandom next;
    public NodeRandom rand;
    private int value;
    public NodeRandom(int value){
        this.value =value;
    }

    public NodeRandom getNode() {
        return next;
    }

    public int getValue() {
        return value;
    }
}
